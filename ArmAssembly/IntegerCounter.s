;Karim Atalla
;Comp Sci 122 MW 5pm

mov r1, #0  			;sets the file up to read
ldr r0, =inputfile 		;load register
swi 0x66 				;open a file
bcs NoFileFound 		;file not found exception
mov r3, r0				;store file handle  stores the address of the file in r3
swi 0x6c				;read integer from file and puts it in r0
bcs ReadError
mov r9, #1 				;start counting integers
mov r4, r0 				;moves the read input from r0 to r4 x value
mov r7, #1				;start counting x's
mov r0, r3				;moves the adress of the file back into r0
swi 0x6c				;read second integer into r0
bcs ReadError
add r9,r9,#1 			;increment count
mov r5, r0				;moves next integer into r5 y value
mov r8, #1				;start counting y's
cmp r4, r5
addeq r8,r8, #1			;compare x to y if equal r8++
cmp r5, r4
addge r7,r7, #1 		;if y greater or equal to x then r7++


						; done with special cases for x and y

loop:					;loops until end of file in reached
mov r0, r3;
swi 0x6c;
bcs done 				;end reached or error reading int exit loop
mov r6,r0
add r9,r9,#1			;increment counter
cmp r5, r6 				;compare to y
addeq r8,r8, #1			;increment if equal
cmp r6, r4				;compare to x
addge r7,r7, #1			;increment if equal or greater
b loop					;go back to beggining of loop
done:
						;end of the loop here

;                   *this section prints out the results*
mov r0, #1 				;print to stdout       
ldr r1, =IntegerX           			
swi 0x69;	
mov r1, r4
swi 0x6b  
ldr r1, =newline;
swi 0x69
ldr r1, =IntegerY           			
swi 0x69;										
mov r1, r5;										
swi 0x6b;										
ldr r1, =newline         ;load blank 				
swi 0x69;
ldr r1, =NumX;									
swi 0x69;
		       ;print blank				
mov r1, r7;										
swi 0x6b;									
ldr r1, =newline         ;load blank 				
swi 0x69;
ldr r1, =NumY;									
swi 0x69;									
mov r1, r8;										
swi 0x6b;										
ldr r1, =newline;									
swi 0x69;
ldr r1, =Total;									
swi 0x69;										
mov r1, r9;										
swi 0x6b;										
ldr r1, =newline;			*end of printing*
swi 0x69;         --------------------------------------

swi 0x68				;close file

swi 0x11				;endprogram
NoFileFound:            ;no file error message
mov R0, #1
ldr R1, =FileNotFound
swi 0x69
swi 0x11
ReadError:              ; if wrong format or less than two integers in file
mov R0, #1
ldr R1, =ErrorReading
swi 0x69
swi 0x11


.data
IntegerX: .asciz "Integer X : "
IntegerY: .asciz "Integer Y : "
NumX:     .asciz "Number of integers equal to or greater than X : "
NumY:     .asciz "Number of times Y appears in the file: "
Total:    .asciz "Total number of integers: "
FileNotFound: .asciz "File not found \n"
ErrorReading: .asciz "File Format error or file too short"
newline: .asciz "\n" ;new line 
blank: .asciz " "; blank space 
inputfile: .asciz "integers.dat" ;read file
