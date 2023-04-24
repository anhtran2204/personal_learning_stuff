	.data
byteVar1:	.byte 'A'
byteVar2: 	.byte 'B'
newLine: 	.byte '\n'
horiLine:	.byte '_'
msg1:		.asciiz	"Same!\n"
msg2:		.asciiz	"Different!\n"

	.text
main:
	
	li $t0, 0
	#la $t0, byteVar1
	lb $a0, byteVar1($t0)
	addi $a0, $a0, -65
	li $v0, 1
	syscall
	
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	
	lb $a0, byteVar2($0)
	addi $a0, $a0, -65
	li $v0, 1
	syscall
	
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	
	lb $a0, horiLine
	li $v0, 11
	syscall
	
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	
	#li $s6, 1
	checkEqual:
		beq $s6, $0, same
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
