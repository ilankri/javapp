SHELL = /bin/sh
JAVAC = javac
JAVACFLAGS = -g -Xlint
JAVA = java
CLASSPATH = .:parser/java-cup-11a-runtime.jar:parser/parseur.jar

dirs = . ASA printer
srcs = $(foreach dir,$(dirs),$(wildcard $(dir)/*.java))
compile = $(JAVAC) -cp $(CLASSPATH) $(JAVACFLAGS)
target = JavaPP.class

.PHONY: all clean

all: $(target)

$(target): $(srcs)
	$(compile) $<

clean:
	$(RM) $(foreach dir,$(dirs),$(addsuffix *.class,$(dir)/))
