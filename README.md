fetch = FetchType.Eager
<---------------------->
by defualt used in manyToOne or OneToOne architecture 
gives all the data from db once only now user can take care of it as its want 

<----------------------------------------------------------------------------------------------------------------------------------------------------------------->

fetch = FetchType.LAZY
<--------------------->

by default used in OneToMany ManyToMany architecture
where we do join operation before that it gives all the data and then when we instatiate join opertaion then only it gives the data
for execution of join

