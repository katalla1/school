swi 0x200 
mov r0, #3; 
mov r1, #5;
mov r2, #1024 
mov r4, #1024 
swi 0x205 
ADDING:
mov r0, #0x01 
swi 0x201 
swi 0x202 
cmp r0, #0x02
beq SUBTRACTING
swi 0x203 
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
bal ADDING
addzero:
mov r0, # 0X80 | 0X40 | 0X20 | 0X08 | 0X04 | 0X01
swi 0x200
b ADDING
addone:
mov r0, # 0X40 | 0X20
swi 0x200
add r4, r4, #1
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addtwo:
mov r0, #0X80 | 0X40 | 0X02 | 0X04 | 0X08
swi 0x200
add r4, r4, #2
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addthree:
mov r0, #0X80 | 0X40 | 0X20 | 0X08 |0X02
swi 0x200
add r4, r4, #3
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addfour:
mov r0, #0X01 | 0X02 | 0X40 | 0X20
swi 0x200
add r4, r4, #4
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addfive:
mov r0, #0X80 | 0X01 | 0X02 | 0X20 | 0X08
swi 0x200
add r4, r4, #5
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addsix:
mov r0, #0X80 | 0X01 | 0X04 | 0X08 |0X02 | 0X20
swi 0x200
add r4, r4, #6
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addseven:
mov r0, #0X80 | 0X40 | 0X20
swi 0x200
add r4, r4, #7
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addeight:
mov r0, #0X80 | 0X40 | 0X20 | 0X08 | 0X04 | 0X02 | 0X01
swi 0x200
add r4, r4, #8
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addnine:
mov r0, #0X80 | 0X40 | 0X20 | 0X08 | 0X02 | 0X01
swi 0x200
add r4, r4, #9
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addten:
mov r0, #0X80 | 0X40 | 0X20 | 0X04 | 0X02 | 0X01
swi 0x200
add r4, r4, #10
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addeleven:
mov r0, #0X01 | 0X04 | 0X08 |0X02 | 0X20
swi 0x200
add r4, r4, #11
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addtweleve:
mov r0, #0X80 | 0X08 | 0X04 | 0X01
swi 0x200
add r4, r4, #12
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addthirteen:
mov r0, #0X40 | 0X20 | 0X08 | 0X04 | 0X02
swi 0x200
add r4, r4, #13
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addfourteen:
mov r0, #0X80 | 0X08 | 0X04 | 0X02 | 0X01
swi 0x200
add r4, r4, #14
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING
addfifteen:
mov r0, #0X80 | 0X01 | 0X02 | 0X04
swi 0x200
add r4, r4, #15
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b ADDING

SUBTRACTING:
mov r0, #0x02 
swi 0x201 
swi 0x202 
cmp r0, #0x01
beq ADDING
swi 0x203 
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
bal SUBTRACTING
subzero:
mov r0, # 0X80 | 0X40 | 0X20 | 0X08 | 0X04 | 0X01
swi 0x200
b SUBTRACTING
subone:
mov r0, # 0X40 | 0X20
swi 0x200
sub r4, r4, #1
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subtwo:
mov r0, #0X80 | 0X40 | 0X02 | 0X04 | 0X08
swi 0x200
sub r4, r4, #2
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subthree:
mov r0, #0X80 | 0X40 | 0X20 | 0X08 |0X02
swi 0x200
sub r4, r4, #3
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subfour:
mov r0, #0X01 | 0X02 | 0X40 | 0X20
swi 0x200
sub r4, r4, #4
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subfive:
mov r0, #0X80 | 0X01 | 0X02 | 0X20 | 0X08
swi 0x200
sub r4, r4, #5
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subsix:
mov r0, #0X80 | 0X01 | 0X04 | 0X08 |0X02 | 0X20
swi 0x200
sub r4, r4, #6
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subseven:
mov r0, #0X80 | 0X40 | 0X20
swi 0x200
sub r4, r4, #7
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subeight:
mov r0, #0X80 | 0X40 | 0X20 | 0X08 | 0X04 | 0X02 | 0X01
swi 0x200
sub r4, r4, #8
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subnine:
mov r0, #0X80 | 0X40 | 0X20 | 0X08 | 0X02 | 0X01
swi 0x200
sub r4, r4, #9
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subten:
mov r0, #0X80 | 0X40 | 0X20 | 0X04 | 0X02 | 0X01
swi 0x200
sub r4, r4, #10
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subeleven:
mov r0, #0X01 | 0X04 | 0X08 |0X02 | 0X20
swi 0x200
sub r4, r4, #11
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subtweleve:
mov r0, #0X80 | 0X08 | 0X04 | 0X01
swi 0x200
sub r4, r4, #12
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subthirteen:
mov r0, #0X40 | 0X20 | 0X08 | 0X04 | 0X02
swi 0x200
sub r4, r4, #13
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subfourteen:
mov r0, #0X80 | 0X08 | 0X04 | 0X02 | 0X01
swi 0x200
sub r4, r4, #14
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
subfifteen:
mov r0, #0X80 | 0X01 | 0X02 | 0X04
swi 0x200
sub r4, r4, #15
mov r0, #3 
mov r1, #5 
ldr r2, =erase
swi 0x204
mov r0, #3
mov r1, #5
mov r2, r4
swi 0x205
b SUBTRACTING
.data
erase: .asciz "      "
