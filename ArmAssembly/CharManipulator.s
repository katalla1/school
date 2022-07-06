;Karim Atalla
;Comp 122 project 2
mov r1,#0        ;reading from file mode 0
ldr r0,=Textfile; reading from file
swi 0x66 
bcs NoFileFound    ;if opening file fails
ldr r1, =MyString   ; where the string will be stored
str r1,[r1]         ; stores the value in memory in a place called [r1]
mov r2,#1020      ; specified how many character to read     
swi 0x6a          ;  read a string
ldr r1, =MyString
mov r8, r0      ; how many characters entered in the string
mov r9 , #0     ; initialize the counter
ldr r5, =OutputString   ; where the outputstring will be stored
str r5,[r5]  
Processing:
cmp r9, r8 ; to see if all characters have been read
beq done
ldrb r0, [r1]   ; grabs only one byte into the register
cmp r0, #40					
Beq Skipper; skips parenthesis
Back:
ldrb r0, [r1]
cmp r0, #97				
addeq r0,r0, #-32; cap A
cmp r0, #101				
addeq r0,r0, #-32; cap E
cmp r0, #105				
addeq r0,r0, #-32; cap I
cmp r0, #111				
addeq r0,r0, #-32; cap O
cmp r0, #117				
addeq r0,r0, #-32; cap U
strb r0, [r5]
add r5,r5, #1; write to output string
add r1,r1,#1  ;moves over one byte to store next letter
add r9, r9, #1
ldrb r0, [r1] ;read into r0

b Processing
Skipper:        ; skips inside of parenthesis
add r1,r1, #1;
add r9, r9, #1
ldrb r0, [r1]
cmp r0, #41
Beq Skip1
b Skipper
Skip1:
add r1,r1, #1;; gets rid of ) parenthesis
add r9, r9, #1
b Back
done:  ; exits the processing loop here
mov r1,#1         
ldr r0,=Outputfile    ; creates outputfile 
swi 0x66 
ldr r1,=OutputString
swi 0x69
mov R0, #1
ldr R1, =Finished
swi 0x69


swi 0x11 ; exit the program
NoFileFound:            ;no file error message
mov r0, #1
ldr r1, =FileNotFound
swi 0x69
swi 0x11
.data
OutputString: .skip 1020
MyString: .skip 1020
.align               ; takes to next memory page
MyFileHandle: .skip 4; skips 4 bytes
Textfile: .asciz "input.txt"
Outputfile: .asciz "output.txt"
Opened: .asciz "File opened for reading \n"
FileNotFound: .asciz "File not found \n"
Finished: .asciz "Processing complete, ending program"