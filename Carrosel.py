carros = int(input())
entrada = input().split(' ')
num = []
seq = []

for i in range(0, carros):
    num.append(int(entrada[i]))
    
for i  in range(0, carros):
	cont = 0
	x = i
	while(x < (carros + 1)):
		if(x == (carros - 1)): 
			if(num[x] < num[0]):
			    cont += 1
			    x = 0
			else:
			    break
		else:
			if(num[x] < num[x+1]):
				cont += 1
				x += 1
			else:
			    break
	seq.append(cont+1)

print(max(seq))