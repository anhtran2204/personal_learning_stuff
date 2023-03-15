	.data
length: .word 0
prompt: .asciiz "Give me a number between 1 and 10 (0 to stop): "

	.text 
main:
	li $v0, 4				# Print prompt asking for user input
	la $a0, prompt
	syscall
	
	li $v0, 5				# Asking for user input
	syscall
	
	
