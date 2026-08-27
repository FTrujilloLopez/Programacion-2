program calculodefactorial;


function factorial (n:integer):real;
begin
  if n <= 1 then
     factorial:= 1
  else
     factorial:= n * factorial(n-1);
end;

{PROGRAMA PRINCIPAL}
var
  num: integer;
Begin

  writeln( 'Ingrese un entero no negativo:');
  readln (num);

  writeln ( num, '! = ', factorial(num):2:0);
  readln;
End.
