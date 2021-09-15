media = 0
total = 0
old = 0

while True:
  age = int(input())
    
  if age == -1:
    break
  
  if age > old:
    old = age
  
  total += 1
  code = input()
  code = code.split(' ')
  
  if(code[0] == 'f' and code[1] == 'l'and code[2] == 'v' and age <= 35 and age >= 18):
    media += 1
    
  
print(f'Mais velho: {old}')
print('Mulheres com olhos verdes, loiras com 18 a 35 anos: {:.2f}%'.format((media/total)*100))