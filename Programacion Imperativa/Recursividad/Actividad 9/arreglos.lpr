program arreglos;

const
    dimF = 8;  {Dimensión física del vector}

type

    vector = array [1..dimF] of LongInt;

    dim = 0..dimF;


{-----------------------------------------------------------------------------
CARGARVECTOR - Carga nros aleatorios entre 0 y 100 en el vector hasta que
llegue el nro 99 o hasta que se complete el vector}
Procedure cargarVector ( var vec: vector; var dimL: dim);
var
   d: integer;
begin
     Randomize;  { Inicializa la secuencia de random a partir de una semilla}
     dimL := 0;
     d:= random(100);
     while (d <> 99)  and ( dimL < dimF ) do begin
           dimL := dimL + 1;
           vec[dimL] := d;
           d:= random(100);
     end;
End;



{-----------------------------------------------------------------------------
IMPRIMIRVECTOR - Imprime todos los nros del vector }
Procedure imprimirVector ( var vec: vector; var dimL: dim );
var
   i: dim;
begin
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(vec[i] < 9)then
            write ('0');
        write(vec[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;

{----------------------------------------------------------------------------
MAXIMOVALOR - Devuelve el maximo valor del vector recibido }
function ObtenerMaximo(v:vector; indice:integer; ultimo:integer):integer;
var
   Max:integer;
begin
     if (indice >= ultimo) then
       ObtenerMaximo:=v[indice]
     else
       begin
        Max:=ObtenerMaximo(v,indice + 1,ultimo);
        if(v[indice] > Max) then
          ObtenerMaximo:=v[indice]
        else
          ObtenerMaximo:=Max;
       end;
end;

{----------------------------------------------------------------------------
SUMADELVECTOR - Suma todos lo numeros que estan en el vector }
function SumaVector(v:vector; indice:integer; ultimo:integer):integer;
begin
   if(indice = ultimo) then
     SumaVector:=v[indice]
   else
     SumaVector:= v[indice] + SumaVector(v,indice + 1,ultimo);
end;



{PROGRAMA PRINCIPAL}
var
   v: vector;
   dimL : dim;
   indice:integer;

begin

     cargarVector(v,dimL);

     writeln('Nros almacenados: ');
     imprimirVector(v, dimL);
     writeln('Numero Maximo del vector: ',ObtenerMaximo(v,1,dimL));
     writeln('Suma total del vector: ',SumaVector(v,1,dimL));
     readln;
end.
