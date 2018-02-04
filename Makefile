SHELL = /bin/sh
JAVAC = javac
JAVACFLAGS = -g -Xlint
CLASSPATH = .:parser/java-cup-11a-runtime.jar:parser/parseur.jar

CTAGS = etags
TAGS = TAGS

dirs = . ASA printer
srcs = $(foreach dir,$(dirs),$(wildcard $(dir)/*.java))
cls = $(srcs:.java=.class)

compile = $(JAVAC) -cp $(CLASSPATH) $(JAVACFLAGS)

.SUFFIXES:
.SUFFIXES: .class .java
.PHONY: all clean maintainer-clean

all: $(cls)

%.class: %.java
	$(compile) $<

$(TAGS): $(srcs)
	$(CTAGS) $^

clean:
	$(RM) $(foreach dir,$(dirs),$(addsuffix *.class,$(dir)/))

maintainer-clean: clean
	$(RM) $(TAGS)
