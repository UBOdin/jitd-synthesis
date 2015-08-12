

FILES = \
	src/util/ListUtils \
	src/jitfuel/Type \
	src/jitfuel/Expression \
	src/jitfuel/Cog \
	src/jitfuel/Typechecker \
	src/jitfuel/Pattern \
	src/exec/Value\
	src/exec/Runtime

LIBS = str

LEXERS  = src/parser/JFLexer
PARSERS = src/parser/JFParser

AUTOGENFILES = \
	$(patsubst %.mly, %, $(PARSERS))\
	$(patsubst %.mll, %, $(LEXERS))

FILES += $(AUTOGENFILES)
DIRS = $(shell for i in $(FILES) ; do dirname $$i; done | sort | uniq)

OCAML_ARGS += $(patsubst %,%.cma,$(LIBS))

OCAMLC = ocamlc -g $(patsubst %, -I %, $(DIRS)) $(OCAML_ARGS)
OCAMLTOP = ocamlmktop $(patsubst %, -I %, $(DIRS))

C_FILES = $(patsubst %, %.cmo, $(FILES))

all: jitd jitd_top

$(patsubst %, %.ml,$(LEXERS)) : %.ml : %.mll
	@echo Building Lexer $(patsubst src/%,%,$(*))
	@ocamllex $< 

$(patsubst %, %.ml,$(PARSERS)) : %.ml : %.mly
	@echo Building Parser $(patsubst src/%,%,$(*))
	@ocamlyacc $<

$(C_FILES) : %.cmo : %.ml
	@if [ -f $(*).mli ] ; then \
		echo Compiling Header $(patsubst src/%,%,$(*));\
		$(OCAMLC) -c $(*).mli;\
	fi
	@echo Compiling $(patsubst src/%,%,$(*))
	@$(OCAMLC) -c $<

jitd: $(patsubst %, %.cmo, $(FILES)) src/Driver.ml
	@echo Building $(patsubst src/%,%,$@)
	@$(OCAMLC) -o $@ $^

jitd_top: $(patsubst %, %.cmo, $(FILES)) 
	@echo Building Top $@
	@$(OCAMLTOP) -o $@ $^

clean: 
	rm -f $(patsubst %,%.ml,$(AUTOGENFILES)) $(patsubst %,%.mli,$(PARSERS))
	rm -f jitd jitd_top
	rm -f $(patsubst %,%/*.cmo,$(DIRS))
	rm -f $(patsubst %,%/*.cmx,$(DIRS))
	rm -f $(patsubst %,%/*.cmi,$(DIRS))
	rm -f $(patsubst %,%/*.cmxi,$(DIRS))

test/unit_test: Makefile
	@echo "Assembling unit tester"
	@echo '#!/bin/bash|BASE=`dirname $$0`/..|TOP=$$BASE/jitd_top|$$TOP $(patsubst %,-I ../%,$(DIRS)) $$*' | tr '|' '\n' > $@
	@chmod +x $@

test: jitd_top test/unit_test
	@make -C test

##########

dep: makefile.dep

makefile.dep: 
	ocamldep $(patsubst %, -I %, $(DIRS)) $(patsubst %, %.ml, $(FILES)) > makefile.dep

include makefile.dep

##########

.PHONY: all clean test dep
