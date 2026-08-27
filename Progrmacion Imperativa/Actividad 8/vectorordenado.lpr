program vectorordenado;

const
    dimF = 8;  {Dimensión física del vector}

type

    vector = array [1..dimF] of integer;

    dim = 0..dimF;

{-----------------------------------------------------------------------------
CARGARVECTORORDENADO - Carga ordenadamente nros aleatorios entre 0 y 100 en el
vector hasta que llegue el nro 99 o hasta que se complete el vector}

Procedure cargarVectorOrdenado ( var vec: vector; var dimL: dim);
var
   d, pos, j: integer;
begin
    Randomize;  { Inicializa la secuencia de random a partir de una semilla}
    dimL := 0;
    d:= random(100);
    while (d <> 99)  and ( dimL < dimF ) do begin
       pos:= 1;
       while (pos <= dimL) and (vec[pos]< d) do pos:= pos + 1;
       for  j:= dimL downto pos do vec[j+1]:= vec[j] ;
       vec[pos]:= d;
       dimL := dimL + 1;
       d:= random(100)
     end;
end;

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

//implementamos busqueda dicotomica
function busquedaDicotomica (vec: vector; primero:integer; ultimo: dim; dato:integer): boolean;
var

   medio: integer;
begin
    if (primero > ultimo) then
        busquedaDicotomica:= false
    else
    begin
      medio:= (primero + ultimo) div 2;
       if (vec[medio] = dato) then
          busquedaDicotomica:= true
         else
           if (vec[medio] > dato) then
              busquedaDicotomica:= busquedaDicotomica(vec, primero, medio - 1, dato)
              else
                if (vec[medio] < dato) then
                    busquedaDicotomica:= busquedaDicotomica(vec,medio + 1, ultimo, dato);

    end;



end;
{PROGRAMA PRINCIPAL}
var
   v: vector;
   dimL : dim;
   primero: integer;
   numerito: integer;

begin
     primero:= 1;
     cargarVectorOrdenado(v,dimL);

     writeln('Nros almacenados: ');
     imprimirVector(v, dimL);
     writeln ('Escriba un numero para buscar');
     readln (numerito);
     if(busquedaDicotomica (v,primero,dimL,numerito))then
         writeln('El numerito se encontro')
     else
         writeln('El numerito NO se encontro');


     readln;

end.
