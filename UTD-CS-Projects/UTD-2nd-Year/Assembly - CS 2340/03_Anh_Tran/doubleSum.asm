	.data 
array: .word 80
prompt: .asciiz 	"Enter an integer (0 to 100): "
error: .asciiz "Invalid message!"
arrSize: .word 0
X: .word 0
	
	.text
main:	
	li $v0, 4
	la $a0, prompt
	syscall
			
	li $v0, 5
	syscall
	sw $v0, X
	
	sll $a0, X, 2
	li $a0, array
	li $v0, 9
	syscall
	
	beq X, $zero, err
	j storeArray
	
errorDisplay:		
	li $v0, 4
	la $a0, error
	syscall
		
	j main
	
storeArray:
		
			
				
					
							