.data
prompt: .asciiz "Enter 2 numbers: "
num1Prompt: .asciiz "- First num: "
num2Prompt: .asciiz "- Second num: "
sumPrompt: .asciiz "Sum: "
newLine: .asciiz "\n"
	
num1: .word 0
num2: .word 0
sum: .word 0
	
	.text
.globl main
main:
	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 4
	la $a0, newLine
	syscall
	
	li $v0, 4
	la $a0, num1Prompt
	syscall
		
	li $v0, 5
	syscall
	sw $v0, num1
	
	li $v0, 4
	la $a0, num2Prompt
	syscall
		
	li $v0, 5
	syscall
	sw $v0, num2
		
	lw $a0, num1
	lw $a1, num2
	jal calcSum
	sw $v0, sum
		
	li $v0, 4
	la $a0, sumPrompt
	syscall
		
	li $v0, 1
	lw $a0, sum
	syscall
	
	lw $s0, board
		
exit:
	li $v0, 10
	syscall
