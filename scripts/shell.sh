pwd
false
sudo apt-get install -y mailutils
echo "Mandando email com mailutils do linux, seu codigo deu certo!" | mail -s "Teste de email" "$RECIPIENT_EMAIL"