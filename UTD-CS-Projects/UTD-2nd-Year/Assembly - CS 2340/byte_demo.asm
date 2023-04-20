	.data
byteVar:	.byte '1'

	.text
main:
	la $t0, byteVar
	lb $a0, 0($t0)
	li $v0, 11
	syscall
	
	li $v0, 10
	syscall