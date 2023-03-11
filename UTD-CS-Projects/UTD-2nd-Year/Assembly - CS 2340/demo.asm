	.data
prompt1: .asciiz "Enter 1st number: "
prompt2: .asciiz "Enter 2nd number: "
prompt3: .asciiz "Sum of "
prompt4: .asciiz " and "
prompt5: .asciiz " is: "
X: .word 0
Y: .word 0
S: .word 0
	
	.text
main:
	li $v0, 5
	syscall
	sw $v0, X
	
	li $v0, 5
	syscall
	sw $v0, Y
	
	lw $s0, X
	lw $s1, Y
	add $s2, $s0, $s1
	add $s2, $s2, 1
	sw $s2, S
	
	lw $a0, S
	li $v0, 1
	syscall
	
	li $v0, 10
	syscall
