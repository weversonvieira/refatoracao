//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws Exception {

    String result = "";

    int totalAmount = 0;
    int volumeCredits = 0;

    List<Atores> atores = carregarAutores();
    List<Performances> performances = invoice(atores);

    result = "Statement for BigCo";
    System.out.println(result);

    for(int i = 0; i < performances.size(); i++){
        Atores ator = performances.get(i).getAtores();
        int thisAmount = 0;

        switch(ator.getTipo()){

            case "tragedy":
                thisAmount = 40000;
                if(performances.get(i).getAudience() > 30){
                    thisAmount += 1000 * (performances.get(i).getAudience() - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if(performances.get(i).getAudience() > 20){
                    thisAmount += 10000 + 500 * (performances.get(i).getAudience() - 20);
                }
                thisAmount += 300 * performances.get(i).getAudience();
                break;
            default:
                throw new Exception("unknow type:" + ator.getTipo());

        }

        volumeCredits += Math.max(performances.get(i).getAudience() - 30, 0);
        if("comedy".equals(ator.getTipo())){
            volumeCredits += (int) Math.floor(performances.get(i).getAudience().doubleValue() / 5);
        }

        result = " " + performances.get(i).getAtores().getNome() + ": $" + thisAmount  + " (" + performances.get(i).getAudience() + " seats)";
        System.out.println(result);
        totalAmount += thisAmount;
    }


    result = "";
    result += "Amount owed is " +  totalAmount / 100 + "\n";
    result += "You earned " + volumeCredits + " credits ";

    System.out.println(result);


}

// 👇 Dados ficam aqui
public static List<Atores> carregarAutores() {

    List<Atores> atores = new ArrayList<>();

    Atores atores1 = new Atores();
    atores1.setNome("Hamlet");
    atores1.setTipo("tragedy");

    Atores atores2 = new Atores();
    atores2.setNome("As You Like It");
    atores2.setTipo("comedy");


    Atores atores3 = new Atores();
    atores3.setNome("Othello");
    atores3.setTipo("tragedy");

    atores.add(atores1);
    atores.add(atores2);
    atores.add(atores3);

    return atores;
}

public static List<Performances> invoice(List<Atores> atores) {
    List<Performances> performances = new ArrayList<>();

    for (Atores ator : atores) {
        Performances performance = new Performances();
        performance.setAtores(ator);
        performances.add(performance);
    }

    performances.get(0).setAudience(55);
    performances.get(1).setAudience(35);
    performances.get(2).setAudience(40);

    return performances;

}



