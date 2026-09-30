import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Pessoa pessoa;
        while (true) {
            System.out.println("Selecione a opção para continuar:");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Consultar pessoa");
            System.out.println("4 - Atualizar pessoa");
            System.out.println("5 - Excluir pessoa");
            System.out.println("0 - Sair");
            int menu ;
            try{
                menu = sc.nextInt();
                sc.nextLine();
                if(menu < 0 || menu > 5){
                    System.out.println("Você deve digitar um numero entre 0 e 5");
                    continue;
                }
            }catch (InputMismatchException e){
                System.out.println("Você deve digitar um numero entre 0 e 5");
                System.out.println("Erro: "+e.getMessage());
                sc.nextLine();
                continue;
            }
            switch(menu){
                case 1:
                    System.out.println("Cadastrar pessoa");
                    System.out.print("Digite o nome do pessoa: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a idade do pessoa: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o email da pessoa: ");
                    String email = sc.nextLine();
                    pessoa = new Pessoa(nome, idade, email);
                    pessoas.add(pessoa);
                    break;
                case 2:
                    for(Pessoa p : pessoas){
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("Qual email da pessoa que você gostaria de consultar?");
                    String emailConsultar = sc.nextLine();
                    for(Pessoa p : pessoas){
                        if(p.getEmail().equals(emailConsultar)){
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Qual email da pessoa que você gostaria de atualizar?");
                    String atualizar = sc.nextLine();
                    for(Pessoa p : pessoas){
                        if(p.getEmail().equals(atualizar)){
                            System.out.println(p);
                            System.out.println("Qual informação voce gostaria de atualizar?");
                            System.out.println("1- Nome: "+p.getNome());
                            System.out.println("2- Idade: "+p.getIdade());
                            System.out.println("3- Email: "+p.getEmail());
                            int menuUpdate ;
                            try{
                                menuUpdate = sc.nextInt();
                                sc.nextLine();
                                if(menuUpdate < 1 || menuUpdate > 3){
                                    System.out.println("Você deve digitar um numero entre 1 e 3");
                                    continue;
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Você deve digitar um numero entre 1 e 3");
                                System.out.println("Erro: "+e.getMessage());
                                sc.nextLine();
                                continue;
                            }
                            switch(menuUpdate){
                                case 1:
                                    System.out.println("Qual novo nome para o cadastro?");
                                    p.setNome(sc.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Para qual idade sera atualizada o cadastro?");
                                    p.setIdade(sc.nextInt());
                                    break;
                                case 3:
                                    System.out.println("Qual novo email para o cadastro?");
                                    p.setEmail(sc.nextLine());
                                    break;
                            }

                        }
                    }
                    break;
                case 5:
                    System.out.println("Qual email da pessoa que você gostaria de excluir?");
                    String excluir = sc.nextLine();
                    for(Pessoa p : pessoas){
                        if(p.getEmail().equals(excluir)){
                            System.out.println(p);
                            System.out.println("Você tem certeza que desejas excluir esse cadastro: "+p);
                            System.out.println("1- Sim");
                            System.out.println("2- Não");
                            int menuExcluir;
                            try{
                                menuExcluir = sc.nextInt();
                                sc.nextLine();
                                if(menuExcluir < 1 || menuExcluir > 2){
                                    System.out.println("Você deve digitar um numero entre 1 e 2");
                                    continue;
                                }
                            }catch (InputMismatchException e){
                                System.out.println("Você deve digitar um numero entre 1 e 2");
                                System.out.println("Erro: "+e.getMessage());
                                sc.nextLine();
                                continue;
                            }
                            if(menuExcluir == 1){
                                pessoas.remove(p);
                                System.out.println("Cadastro excluido com sucesso!");
                                break;
                            }else if(menuExcluir == 2){
                                System.out.println("Exclusão cancelada!");
                                break;


                            }

                        }
                    }
                    break;
                 case 0:
                     System.out.println("Saindo");
                     return;

            }

        }

    }
}
