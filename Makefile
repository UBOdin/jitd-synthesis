

FILES = \
	src/util/ListUtils \
	src/jitfuel/Type \
	src/jitfuel/Expression \
	src/jitfuel/Cog \
	src/jitfuel/Typechecker \

LIBS = str

LEXERS  = 
PARSERS = 

AUTOGENFILES = \
	$(patsubst %.mly, %, $(PARSERS))\
	$(patsubst %.mll, %, $(LEXERS))

FILES += $(AUTOGENFILES)
DIRS = $(shell for i in $(FILES) ; do dirname $$i; done | sort | uniq)

OCAML_ARGS += $(patsubst %,%.cma,$(LIBS))

OCAMLC = ocamlc -g $(patsubst %, -I %, $(DIRS)) $(OCAML_ARGS)

C_FILES = $(patsubst %, %.cmo, $(FILES))

all: jitd

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

clean: 
	rm -f $(patsubst %,%.ml,$(AUTOGENFILES)) $(patsubst %,%.mli,$(PARSERS))
	rm -f jitd 
	rm -f $(patsubst %,%/*.cmo,$(DIRS))
	rm -f $(patsubst %,%/*.cmx,$(DIRS))
	rm -f $(patsubst %,%/*.cmi,$(DIRS))
	rm -f $(patsubst %,%/*.cmxi,$(DIRS))

##########

dep: makefile.dep

makefile.dep: $(patsubst %, %.ml, $(AUTOGENFILES))
	ocamldep $(patsubst %, -I %, $(DIRS)) $(patsubst %, %.ml, $(FILES)) > makefile.dep

include makefile.dep

##########

.PHONY: all clean test dep
