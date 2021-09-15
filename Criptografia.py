from math import floor

n = int(input())
cifrada = ""

nA = ord('A')
nZ = ord('Z')
na = ord('a')
nz = ord('z')

for i in range(n):
  phrase = input()
  # Primeira passada +3 na tabela ASCII
  for caracter in phrase:
      ind = ord(caracter)
      if nA <= ind <= nZ:
          new_char = chr(ord(caracter) + 3)
          cifrada += new_char
      elif ind in range(na, nz+1):
          new_char = chr(ord(caracter) + 3)
          cifrada += new_char
      else:
          cifrada += caracter
  
  # A linha dever� ser invertida
  cifrada = cifrada[::-1]
  
  # deslocados uma posi��o para a esquerda na tabela ASCII
  cifrada_aux = list(cifrada)
  value = floor(len(cifrada_aux)/2)
  
  for i in range(value, len(cifrada_aux)):
    cifrada_aux[i] = chr(ord(cifrada_aux[i]) - 1)
    
  result = ''.join(cifrada_aux)
  print(result)
  cifrada = ""