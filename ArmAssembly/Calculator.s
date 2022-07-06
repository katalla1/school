;Karim Atalla
;Comp 122 Project 3

;8 segment display
.equ SEG_A,0X80
.equ SEG_B,0X40
.equ SEG_C,0X20
.equ SEG_D,0X08
.equ SEG_E,0X04
.equ SEG_F,0X02
.equ SEG_G,0X01
; DEFINES WHICH PARTS OF THE 8-SEGMENT DISPLAY LIGHTS UP
.equ ZERO, SEG_A | SEG_B | SEG_C | SEG_D | SEG_E | SEG_G
.equ ONE, SEG_B | SEG_C
.equ TWO, SEG_A | SEG_B | SEG_F | SEG_E | SEG_D
.equ THREE, SEG_A | SEG_B | SEG_C | SEG_D |SEG_F
.equ FOUR, SEG_G | SEG_F | SEG_B | SEG_C
.equ FIVE, SEG_A | SEG_G | SEG_F | SEG_C | SEG_D
.equ SIX, SEG_A | SEG_G | SEG_E | SEG_D |SEG_F | SEG_C
.equ SEVEN, SEG_A | SEG_B | SEG_C 
.equ EIGHT, SEG_A | SEG_B | SEG_C | SEG_D | SEG_E | SEG_F | SEG_G
.equ NINE, SEG_A | SEG_B | SEG_C | SEG_D | SEG_F | SEG_G
.equ TEN, SEG_A | SEG_B | SEG_C | SEG_E | SEG_F | SEG_G;A
.equ ELEVEN, SEG_G | SEG_E | SEG_D |SEG_F | SEG_C;B
.equ TWELVE, SEG_A | SEG_D | SEG_E | SEG_G;C
.equ THIRTEEN, SEG_B | SEG_C | SEG_D | SEG_E | SEG_F;D
.equ FOURTEEN, SEG_A | SEG_D | SEG_E | SEG_F | SEG_G;E
.equ FIFTEEN, SEG_A | SEG_G | SEG_F | SEG_E;F

swi 0x200 ; BLANK OUT THE 8 SEGMENT DISPLAY
swi 0x206 ; BLANK THE LCD
swi 0x201 ; BLANK THE LEDS

mov r0, #3; column
mov r1, #1; line
ldr r2, =string
swi 0x204; print string on lcd
mov r0, #3; 
mov r1, #3; 
ldr r2, =addmode
swi 0x204
mov r0, #3; 
mov r1, #5;
ldr r2, =value 
swi 0x204

mov r0, #11; 
mov r1, #5;
mov r2, #1024 ; starting value for lcd
mov r4, #1024 ; starting value for calculation
swi 0x205 ; print on lcd

ADDITION:
mov r0, #0x01 
swi 0x201 ; light up left led indicating add function
mov r0, #3; 
mov r1, #3; 
ldr r2, =addmode; change mode on lcd
swi 0x204

ADDING:
swi 0x202 ;check black button
cmp r0, #0x02
beq SUBTRACTION
swi 0x203 ; poll the blue keyboard
cmp r0, #0x0001
beq addzero
cmp r0, #0x0002
beq addone
cmp r0, #0x0004
beq addtwo
cmp r0, #0x0008
beq addthree
cmp r0, #0x0010
beq addfour
cmp r0, #0x0020
beq addfive
cmp r0, #0x0040
beq addsix
cmp r0, #0x0080
beq addseven
cmp r0, #0x0100
beq addeight
cmp r0, #0x0200
beq addnine
cmp r0, #0x0400
beq addten
cmp r0, #0x0800
beq addeleven
cmp r0, #0x1000
beq addtweleve
cmp r0, #0x2000
beq addthirteen
cmp r0, #0x4000
beq addfourteen
cmp r0, #0x8000
beq addfifteen
added:
bal ADDING

SUBTRACTION:
mov r0, #0x02 
swi 0x201 ; light up right led indicating subtract function
mov r0, #3; 
mov r1, #3; 
ldr r2, =submode
swi 0x204
SUBTRACTING:
swi 0x202 ;check black button
cmp r0, #0x01
beq ADDITION
swi 0x203 ; poll the blue keyboard
cmp r0, #0x0001
beq subzero
cmp r0, #0x0002
beq subone
cmp r0, #0x0004
beq subtwo
cmp r0, #0x0008
beq subthree
cmp r0, #0x0010
beq subfour
cmp r0, #0x0020
beq subfive
cmp r0, #0x0040
beq subsix
cmp r0, #0x0080
beq subseven
cmp r0, #0x0100
beq subeight
cmp r0, #0x0200
beq subnine
cmp r0, #0x0400
beq subten
cmp r0, #0x0800
beq subeleven
cmp r0, #0x1000
beq subtweleve
cmp r0, #0x2000
beq subthirteen
cmp r0, #0x4000
beq subfourteen
cmp r0, #0x8000
beq subfifteen
subtracted:
bal SUBTRACTING

;---------------------------------------
;addition processing
addzero:
mov r0, #ZERO
swi 0x200
b added
addone:
mov r0, #ONE
swi 0x200
add r4, r4, #1
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addtwo:
mov r0, #TWO
swi 0x200
add r4, r4, #2
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addthree:
mov r0, #THREE
swi 0x200
add r4, r4, #3
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addfour:
mov r0, #FOUR
swi 0x200
add r4, r4, #4
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addfive:
mov r0, #FIVE
swi 0x200
add r4, r4, #5
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addsix:
mov r0, #SIX
swi 0x200
add r4, r4, #6
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addseven:
mov r0, #SEVEN
swi 0x200
add r4, r4, #7
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addeight:
mov r0, #EIGHT
swi 0x200
add r4, r4, #8
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addnine:
mov r0, #NINE
swi 0x200
add r4, r4, #9
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addten:
mov r0, #TEN
swi 0x200
add r4, r4, #10
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addeleven:
mov r0, #ELEVEN
swi 0x200
add r4, r4, #11
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addtweleve:
mov r0, #TWELVE
swi 0x200
add r4, r4, #12
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addthirteen:
mov r0, #THIRTEEN
swi 0x200
add r4, r4, #13
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addfourteen:
mov r0, #FOURTEEN
swi 0x200
add r4, r4, #14
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
addfifteen:
mov r0, #FIFTEEN
swi 0x200
add r4, r4, #15
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b added
;---------------------------------
;subtraction processing
subzero:
mov r0, #ZERO
swi 0x200
b subtracted
subone:
mov r0, #ONE
swi 0x200
sub r4, r4, #1
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subtwo:
mov r0, #TWO
swi 0x200
sub r4, r4, #2
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subthree:
mov r0, #THREE
swi 0x200
sub r4, r4, #3
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subfour:
mov r0, #FOUR
swi 0x200
sub r4, r4, #4
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subfive:
mov r0, #FIVE
swi 0x200
sub r4, r4, #5
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subsix:
mov r0, #SIX
swi 0x200
sub r4, r4, #6
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subseven:
mov r0, #SEVEN
swi 0x200
sub r4, r4, #7
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subeight:
mov r0, #EIGHT
swi 0x200
sub r4, r4, #8
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subnine:
mov r0, #NINE
swi 0x200
sub r4, r4, #9
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subten:
mov r0, #TEN
swi 0x200
sub r4, r4, #10
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subeleven:
mov r0, #ELEVEN
swi 0x200
sub r4, r4, #11
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subtweleve:
mov r0, #TWELVE
swi 0x200
sub r4, r4, #12
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subthirteen:
mov r0, #THIRTEEN
swi 0x200
sub r4, r4, #13
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subfourteen:
mov r0, #FOURTEEN
swi 0x200
sub r4, r4, #14
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
subfifteen:
mov r0, #FIFTEEN
swi 0x200
sub r4, r4, #15
mov r0, #11 
mov r1, #5 
ldr r2, =clear
swi 0x204
mov r0, #11
mov r1, #5
mov r2, r4
swi 0x205
b subtracted
.data
string: .asciz "Project 3 Simple Calculator"
clear: .asciz "                       "
addmode: .asciz "Mode: Addition   "
submode: .asciz "Mode: Subtraction"
value: .asciz "Value: "