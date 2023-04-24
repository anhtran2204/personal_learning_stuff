	.data
input: 		.space	4
newLine:	.byte 	'\n'
prompt:		.asciiz "Enter coordinates to connect > "
before:		.asciiz	"Before: "
after:		.asciiz "After: "
msg1:		.asciiz	"Same!\n"
msg2:		.asciiz	"Different!\n"
	
	.text
main:	
	la $a0, before
	li $v0, 4
	syscall
	lb $a0, input($0)
	la $t0, ($a0)
	li $v0, 1
	syscall
	
	jal addNewLine
	
	la $a0, prompt
	li $v0, 4
	syscall
	li $v0, 8
	la $a0, input
	li $a1, 16
	syscall
	
	la $a0, after
	li $v0, 4
	syscall
	lb $a0, input($0)
	la $t1, ($a0)
	li $v0, 1
	syscall
	
	jal addNewLine
	
	beq $t0, $t1, same
	li $v0, 4
	la $a0, msg2
	syscall
	j done
same:
	li $v0, 4
	la $a0, msg1
	syscall
done:	
	li $v0, 10
	syscall
	
addNewLine:
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	jr $ra