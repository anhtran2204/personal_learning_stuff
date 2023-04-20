	.data
byteVar1:	.byte '1'
byteVar2: 	.byte '2'
newLine: 	.byte '\n'

	.text
main:
	
	li $t0, 0
	#la $t0, byteVar1
	lb $a0, byteVar1($t0)
	li $v0, 11
	syscall
	
	lb $a0, newLine($0)
	li $v0, 11
	syscall
	
	lb $a0, byteVar2($0)
	li $v0, 11
	syscall
	
	li $v0, 10
	syscall
