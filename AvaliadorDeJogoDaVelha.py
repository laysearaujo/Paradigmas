one = "X _ X"
two = "O _ O"
three = "_ _ _"

painting = ' '.join([one,two,three]).split(' ')

count = 0

O_VENCEU = False
X_VENCEU = False

qtd = int(input())

for _ in range(qtd):
    one = input()
    two = input()
    three = input()
    
    painting = ' '.join([one,two,three]).split(' ')
    
    count_total = 0
    count_x = 0
    count_o = 0
    
    O_VENCEU = False
    X_VENCEU = False
    
    valid = True
    
    for element in painting:
      if element == 'X':
        count_total += 1
        count_x += 1        
      elif element == 'O':
        count_total += 1
        count_o += 1
        
    if(count_o > count_x):
      valid = False

    elif(count_x > count_o + 1):
      valid = False
  
    if count_total >= 5 and valid:
        # Topo
        if painting[0] == painting[1] == painting[2] != '_': 
          if(painting[0] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
        
        # Meio
        if painting[3] == painting[4] == painting[5] != '_':
          if(painting[3] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
        
        # Inferior
        if painting[6] == painting[7] == painting[8] != '_':
          if(painting[6] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
        
        # Esquerda
        if painting[0] == painting[3] == painting[6] != '_':
          if(painting[0] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
        
        # Meio Top-Down
        if painting[1] == painting[4] == painting[7] != '_':
          if(painting[1] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
        
        # Direita
        if painting[2] == painting[5] == painting[8] != '_':
          if(painting[2] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
        
        # Diagonal esquerda
        if painting[0] == painting[4] == painting[8] != '_':
          if(painting[0] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
             
        # Diagonal Direita
        if painting[2] == painting[4] == painting[6] != '_':
          if(painting[2] == 'O'):
            O_VENCEU = True
          else:
            X_VENCEU = True
      

    if((O_VENCEU == True and X_VENCEU == True) or not valid):
      print("ILEGAL")
    
    elif(O_VENCEU):
      if(count_x > count_o):
          valid = False
          print("ILEGAL")
      else:
        print("O_VENCEU")
    
    elif(X_VENCEU):
      if(count_o >= count_x):
        valid = False
        print("ILEGAL")
      else:
        print("X_VENCEU")
    
    else:
      print("EM_ANDAMENTO")