	.data
prompt: .asciiz "Enter input > "
success: .asciiz "True"
failure: .asciiz "False"
newLine: .asciiz "\n"
input: .space 4
char:	.byte 'A'
digit:	.word 1

	.text
main:
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 8
	la $a0, input
	li $a1, 4
	syscall
	
	li $v0, 4
	la $a0, input
	syscall
	
	la $t0, input
	lb $t1, ($t0)
	add $s0, $t1, $0
	li $v0, 11
	add $a0, $t1, $0
	syscall
	
	addi $t0, $t0, 1
	
	la $a0, newLine
	li $v0, 4
	syscall
	
	lb $t1, ($t0)
	add $s1, $t1, $0
	add $s1, $s1, -48
	li $v0, 11
	add $a0, $t1, $0
	syscall
	
	lb $s2, char
	lw $s3, digit
	bne $s0, $s2, exit1
	bne $s1, $s3, exit1
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, success
	syscall
	
	li $v0, 10
	syscall
	
	exit1:
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, failure
	syscall
	
	li $v0, 10
	syscall
