### 📊 Checklist de Requisitos Funcionais (RF)

- ✅ **RF01:** O tabuleiro deve começar com todas as casas em branco representando pelo valor "B" (0,5 pts)  
- ✅ **RF02:** O jogador deve escolher a sua cor entre V (vermelho) ou A (azul) (0,5 pts)  
- ❌ **RF03:** Na sua vez, o jogador deve informar uma posição de coluna para jogar. A peça ficará posicionada na primeira linha disponível daquela coluna (considerar a linha mais abaixo possível) (1,0 pt)  
- ❌ **RF04:** O computador deve jogar de forma aleatória ou inteligente (em colunas válidas e livres) (1,0 pt)  
- ❌ **RF05:** O programa deve exibir o tabuleiro atualizado após cada jogada (1,0 pt)  
- ❌ **RF06:** O programa deve validar as jogadas. Não permitir jogar numa coluna cheia ou inexistente (pedir nova posição até ser válida) (1,0 pt)  
- ❌ **RF07:** O programa deve verificar após cada jogada se houve um vencedor (4 peças em linha na horizontal, vertical ou diagonal) (2,0 pts)  
- ❌ **RF08:** O programa deve verificar se houve empate (tabuleiro cheio sem vencedor) (1,0 pt)  
- ❌ **RF09:** Ao finalizar o jogo (com vitória ou empate), o programa deve perguntar se os jogadores desejam jogar novamente. Se sim, reiniciar o tabuleiro mantendo as regras (1,5 pts)  

-mostrar o número da coluna 
- ideia: mostrar uma mensagem com a opção de sempre voltar para o menu
-menu:
-Como Jogar (você escolhe a coluna desejada e bla bla bla)
-Mostrar Tabuleiro
-Continuar jogo (deve retornar para o momento que parou, pedindo para o usuário digitar a coluna. Não apagar o tabuleiro) (questão a se pensar, esse menu será a primeira coisa que o usuário vai ver? Não pode ser permitido continuar jogo - aparecer mensagem que nenhum jogo foi iniciado nessa seção)
-Novo Jogo (apaga o tabuleiro e começa o jogo do início)