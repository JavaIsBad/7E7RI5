jeu : |bytecode
	javac -sourcepath src/ src/*.java -d bytecode
	
bytecode :
	mkdir bytecode

tetris : jeu
	java -cp bytecode Tetris 
	
ia : jeu
	java -cp bytecode IA
	
clean :
	rm -rf bytecode doc
	
doc :
	javadoc src/*.java -d doc
