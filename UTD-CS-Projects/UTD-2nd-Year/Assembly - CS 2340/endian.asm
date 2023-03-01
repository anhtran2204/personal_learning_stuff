.data
	_string: .asciiz "Woosh!"
	
.text
	main:
		la $a0, _string
		li $v0, 1
		syscall 