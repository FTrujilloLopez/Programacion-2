program recursion;

procedure digitoMaximo(n: integer; var max: integer);
var
  dig: integer;
begin
  if (n = 0) then
     max:=n
  else
      begin
         dig:= n mod 10;
         if ( dig > max ) then begin
             max:= dig;
         end;
         n:= n div 10;
         if (n <> 0) then
            digitoMaximo(n, max);
      end;
  writeln('Maximo', max);

end;

var
  num, max: integer;
Begin
  max := -1;
  writeln( 'Ingrese un entero no negativo:');
  readln (num);
  digitoMaximo (num, max);
  writeln ( 'El digito maximo del numero ', num, ' es: ', max);
  readln;
End.

