import java.lang.Math;

class Expr{ 
    public double eval(double x, double y){
        System.out.println("ah");
        return 0;
    }
}
class X extends Expr{
public String toString(){
      return("X");
    }
    @Override
    public double eval(double x, double y){
        return x;
    }
}

class Y extends Expr{
public String toString(){
      return("Y");
    }
    @Override
    public double eval(double x, double y){
        return y;
    }
}

class Sin extends Expr{ 
    Expr op;
    Sin(Expr o){
      op = o;
    }
    public String toString(){
    return("sin(Pi*"+op+")"); 
    }
    @Override
    public double eval(double x, double y){
        return Math.sin(Math.PI * this.op.eval(x,y));
    }
}

class Cos extends Expr{ Expr op;
    Cos(Expr o){
      op = o;
    }
    public String toString(){
        return("cos(Pi*"+op+")"); 
    }
    @Override
    public double eval(double x, double y){
        return Math.cos(Math.PI * this.op.eval(x,y));
    }
}

class Moyenne extends Expr{ 
    Expr op1;
    Expr op2;
    Moyenne(Expr o1,Expr o2){
        op1 = o1;
        op2 = o2; 
    }
    public String toString(){ 
        return("("+op1+"+"+op2+")/2");
    }
    @Override
    public double eval(double x, double y){
        return (this.op1.eval(x,y)+this.op2.eval(x,y))/2;
    }
}

class Mult extends Expr{ Expr op1;
    Expr op2;
    Mult(Expr o1,Expr o2){
        op1 = o1;
        op2 = o2; 
    }
    public String toString(){ return(op1+"*"+op2);
    } 
    @Override
    public double eval(double x, double y){
        return this.op1.eval(x,y)*this.op2.eval(x,y);
    }
}






