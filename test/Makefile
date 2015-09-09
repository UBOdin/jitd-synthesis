

TESTS := \
  typecheck.ml \
  eval.ml \
  pattern.ml \

all: 
	@for i in $(TESTS); do \
		echo "--- Running Test:" `echo $$i | sed 's/\\.ml//'` "---"; \
		./unit_test $$i;\
	done