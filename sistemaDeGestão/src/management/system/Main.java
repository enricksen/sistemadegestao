package management.system;

import java.util.Scanner;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        int tipo;
        int atual;
        int end = 0;
        int end2 = 0;
        int questions;

        String[] prof_name = new String[1000];
        String[] prof_email = new String[1000];
        int prof_numb = 0;

        String[] pes_name = new String[1000];
        String[] pes_email = new String[1000];
        int pes_numb = 0;

        String[] alu_name = new String[1000];
        String[] alu_email = new String [1000];
        int alu_numb = 0;

        String[] adm_name = new String[1000];
        String[] adm_email = new String[1000];
        int adm_numb = 0;

        int aloc_numb = 0;
        String[] aloc_status = new String[1000];
        String[] aloc_thing = new String[1000];
        String[] aloc_man = new String[1000];
        int[] aloc_day = new int[1000];
        int[] aloc_month = new int[1000];
        int[] aloc_year = new int[1000];
        int[] aloc_hour_i = new int[1000];
        int[] aloc_minute_i = new int[1000];
        int[] aloc_hour_f = new int[1000];
        int[] aloc_minute_f = new int[1000];

        int[] aloc_activity_numberpart = new int[1000];
        int aloc_activity_numb = 0;
        String[] aloc_activity_title = new String[1000];
        String[] aloc_activity_material = new String[1000];
        String[] aloc_activity_description = new String[1000];
        String[] aloc_activity_type = new String[1000];



        while(end == 0) {
            end2 = 0;
            System.out.println("========== Sistema de Gest�o ==========");
            System.out.println("");
            System.out.println("Qual o seu n�vel de acesso?");
            System.out.println("(1 - Aluno, 2 - Professor, 3 - Pesquisador, 4 - Administrador)");

            tipo = input.nextInt();

            switch (tipo) {
                case 1:
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("");
                    System.out.println("Voc� � um aluno.");
                    System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
                    questions = input.nextInt();
                    input.nextLine();
                    if(questions == 2){
                        alu_numb++;
                        System.out.println("Voc� � o aluno "+alu_numb+". Escreva seu nome:");
                        alu_name[alu_numb] = input.nextLine();
                        System.out.println("Escreva seu email:");
                        alu_email[alu_numb] = input.nextLine();
                        System.out.println("Voc� est� cadastrado "+alu_name[alu_numb]+"!");
                        atual = alu_numb;
                    }
                    else {
                        System.out.println("Qual seu n�mero de acesso?");
                        atual = input.nextInt();
                        System.out.println("Bem-vindo de volta "+alu_name[alu_numb]+"!");
                    }
                    while(end2 == 0) {
                        System.out.println("Menu de aluno:");
                        System.out.println("1 - Alocar Recursos");
                        System.out.println("2 - Sair");
                        questions = input.nextInt();
                        if(questions == 1){
                            System.out.println("Recursos dispon�veis:");
                            System.out.println("1 - Sala");
                            questions = input.nextInt();
                            if(questions == 1) {
                                System.out.println("Qual sala voc� deseja alocar? (Sala de 1 at� 7)");
                                questions = input.nextInt();
                                System.out.println("Qual o professor respons�vel pela aloca��o? (Digite seu c�digo)");
                                aloc_numb++;
                                int temp = input.nextInt();
                                if(temp > prof_numb)
                                {
                                    aloc_numb--;
                                    System.out.println("Aloca��o n�o dispon�vel");
                                }
                                else
                                {
                                    aloc_man[temp] = "Prof "+temp;
                                    System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                    aloc_day[aloc_numb] = input.nextInt();
                                    aloc_month[aloc_numb] = input.nextInt();
                                    aloc_year[aloc_numb] = input.nextInt();
                                    System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                    aloc_hour_i[aloc_numb] = input.nextInt();
                                    aloc_minute_i[aloc_numb] = input.nextInt();
                                    System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                    aloc_hour_f[aloc_numb] = input.nextInt();
                                    aloc_minute_f[aloc_numb] = input.nextInt();
                                    int free = 1;
                                    for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                        if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                            if(aloc_thing[free_count].equals("Sala "+questions)) {
                                                if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                    free = 0;
                                                }
                                            }
                                        }
                                    }
                                    if(free == 1) {
                                        aloc_status[aloc_numb] = "Em processo de aloca��o";
                                        aloc_thing[aloc_numb] = "Sala "+questions;
                                    } else {
                                        System.out.println("Horario n�o dispon�vel");
                                        aloc_numb--;
                                    }
                                }
                            }
                        } else if(questions == 2) {
                            end2 = 1;
                        }
                    }
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("");
                    System.out.println("Voc� � um professor.");
                    System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
                    questions = input.nextInt();
                    input.nextLine();
                    if(questions == 2){
                        prof_numb++;
                        System.out.println("Voc� � o professor "+prof_numb+". Escreva seu nome:");
                        prof_name[prof_numb] = input.nextLine();
                        System.out.println("Escreva seu email:");
                        prof_email[prof_numb] = input.nextLine();
                        System.out.println("Voc� est� cadastrado "+prof_name[prof_numb]+"!");
                        atual = prof_numb;
                    }
                    else {
                        System.out.println("Qual seu n�mero de acesso?");
                        atual = input.nextInt();
                        System.out.println("Bem-vindo de volta "+prof_name[prof_numb]+"!");
                    }
                    while(end2 == 0)
                    {
                        System.out.println("Menu de professor:");
                        System.out.println("1 - Alocar Recursos");
                        System.out.println("2 - Confirmar aloca��o");
                        System.out.println("3 - Adicionar atividade as aloca��es");
                        System.out.println("4 - Sair");
                        questions = input.nextInt();
                        if(questions == 1){
                            System.out.println("Recursos dispon�veis:");
                            System.out.println("1 - Sala");
                            System.out.println("2 - Laborat�rio");
                            System.out.println("3 - Audit�rio");
                            System.out.println("4 - Projetor");
                            questions = input.nextInt();
                            if(questions == 1)
                            {
                                System.out.println("Qual sala voc� deseja alocar? (Sala de 1 at� 7)");
                                questions = input.nextInt();
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Prof "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Sala "+questions)) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Sala "+questions;
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            } else if(questions == 2) {
                                System.out.println("Qual laborat�rio voc� deseja alocar? (Laborat�rio de 1 at� 4)");
                                questions = input.nextInt();
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Prof "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Laborat�rio "+questions)) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Laborat�rio "+questions;
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            } else if(questions == 3) {
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Prof "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Audit�rio")) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Audit�rio";
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            } else if(questions == 4) {
                                System.out.println("Qual projetor voc� deseja alocar? (Projetores de 1 at� 10)");
                                questions = input.nextInt();
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Prof "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Projetor "+questions)) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Projetor "+questions;
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            }
                        } else if(questions == 2) {
                            System.out.println("Lista de aloca��es:");
                            for(int cont = 1; cont <= aloc_numb; cont++) {
                                if(aloc_man[cont].equals("Prof "+atual)  && aloc_status[cont] == "Alocado") {
                                    System.out.println("� "+cont+" "+aloc_thing[cont]);
                                }
                            }
                            System.out.println("Digite o numero da aloca��o, caso n�o tenha nenhuma ou n�o queira alguma, digite 0");
                            questions = input.nextInt();
                            if(questions != 0) {
                                int aloc2 = questions;
                                int aloc_in = 0;
                                for(int cont = 1; cont <= aloc_numb; cont++) {
                                    if(aloc_man[cont].equals("Prof "+atual) && aloc_status[cont] == "Em Andamento")
                                    {
                                        aloc_in = 1;
                                    }
                                }
                                if(aloc_in == 0) {
                                    System.out.println("Deseja confirmar a aloca��o "+aloc2+"? (1 - Sim / 2 - N�o)");
                                    questions = input.nextInt();
                                    if(questions == 1) {
                                        aloc_status[aloc2] = "Em Andamento";
                                    }
                                } else {
                                    System.out.println("Voc� j� tem uma aloca��o em andamento!");
                                }

                            }
                        } else if(questions == 3) {
                            System.out.println("Lista de aloca��es:");
                            for(int cont = 1; cont <= aloc_numb; cont++) {
                                if(aloc_man[cont].equals("Prof "+atual) && aloc_status[cont] == "Em Andamento") {
                                    System.out.println("� "+cont+" "+aloc_thing[cont]);
                                }
                            }
                            System.out.println("Digite o numero da aloca��o, caso n�o tenha nenhuma ou n�o queira alguma, digite 0");
                            questions = input.nextInt();
                            if(questions != 0) {
                                System.out.println("Deseja adicionar a atividade a aloca��o"+questions+"? (1 - Sim / 2 - N�o)");
                                int aloc2 = questions;
                                questions = input.nextInt();
                                if(questions == 1) {
                                    System.out.println("Qual o tipo de atividade? (1 - Aula tradicional, 2 - Apresenta��o, 3 - Laborat�rio)");
                                    questions = input.nextInt();
                                    input.nextLine();
                                    if(questions == 1) {
                                        aloc_activity_type[aloc2] = "Aula tradicional";
                                    } else if(questions == 2) {
                                        aloc_activity_type[aloc2] = "Apresenta��o";
                                    } else if(questions == 3) {
                                        aloc_activity_type[aloc2] = "Laborat�rio";
                                    }
                                    System.out.println("Digite o titulo da atividade:");
                                    aloc_activity_description[aloc2] = input.nextLine();
                                    System.out.println("Digite a descri��o da atividade:");
                                    aloc_activity_description[aloc2] = input.nextLine();
                                    System.out.println("Digite o link para o material da atividade:");
                                    aloc_activity_description[aloc2] = input.nextLine();
                                    System.out.println("Quantos participantes na atividade?");
                                    aloc_activity_numberpart[aloc2] = input.nextInt();
                                    System.out.println("Atividade cadastrada com sucesso.");
                                    aloc_activity_numb++;
                                }
                            }
                        } else if(questions == 4) {
                            end2 = 1;
                        }
                    }
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("Voc� � um pesquisador.");
                    System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
                    questions = input.nextInt();
                    if(questions == 2){
                        pes_numb++;
                        System.out.println("Voc� � o pesquisador "+pes_numb+". Escreva seu nome:");
                        pes_name[pes_numb] = input.next();
                        System.out.println("Escreva seu email:");
                        pes_email[pes_numb] = input.next();
                        System.out.println("Voc� est� cadastrado "+pes_name[pes_numb]+"!");
                        atual = pes_numb;
                    }
                    else {
                        System.out.println("Qual seu n�mero de acesso?");
                        atual = input.nextInt();
                        System.out.println("Bem-vindo de volta "+pes_name[pes_numb]+"!");
                    }
                    while(end2 == 0)
                    {
                        System.out.println("Menu de pesquisador:");
                        System.out.println("1 - Alocar Recursos");
                        System.out.println("2 - Confirmar aloca��o");
                        System.out.println("3 - Adicionar informa��o as aloca��es");
                        System.out.println("4 - Sair");
                        questions = input.nextInt();
                        if(questions == 1){
                            System.out.println("Recursos dispon�veis:");
                            System.out.println("1 - Sala");
                            System.out.println("2 - Laborat�rio");
                            System.out.println("3 - Audit�rio");
                            System.out.println("4 - Projetor");
                            questions = input.nextInt();
                            if(questions == 1)
                            {
                                System.out.println("Qual sala voc� deseja alocar? (Sala de 1 at� 7)");
                                questions = input.nextInt();
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Pes "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Sala "+questions)) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Sala "+questions;
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            } else if(questions == 2) {
                                System.out.println("Qual laborat�rio voc� deseja alocar? (Laborat�rio de 1 at� 4)");
                                questions = input.nextInt();
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Pes "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Laborat�rio "+questions)) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Laborat�rio "+questions;
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            } else if(questions == 3) {
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Pes "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Audit�rio")) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Audit�rio";
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            } else if(questions == 4) {
                                System.out.println("Qual projetor voc� deseja alocar? (Projetores de 1 at� 10)");
                                questions = input.nextInt();
                                aloc_numb++;
                                aloc_man[aloc_numb] = "Pes "+atual;
                                System.out.println("Digite a data de inicio da aloca��o (dd/mm/yy)");
                                aloc_day[aloc_numb] = input.nextInt();
                                aloc_month[aloc_numb] = input.nextInt();
                                aloc_year[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de inicio da aloca��o (hh/mm)");
                                aloc_hour_i[aloc_numb] = input.nextInt();
                                aloc_minute_i[aloc_numb] = input.nextInt();
                                System.out.println("Digite a hora de fim da aloca��o (hh/mm)");
                                aloc_hour_f[aloc_numb] = input.nextInt();
                                aloc_minute_f[aloc_numb] = input.nextInt();
                                int free = 1;
                                for(int free_count = 1; free_count < aloc_numb; free_count++) {
                                    if(aloc_day[free_count] == aloc_day[aloc_numb] && aloc_month[free_count] == aloc_month[aloc_numb] && aloc_year[free_count] == aloc_year[aloc_numb]) {
                                        if(aloc_thing[free_count].equals("Projetor "+questions)) {
                                            if(((aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) >= (aloc_hour_i[free_count]*100+aloc_minute_i[free_count])) && (aloc_hour_i[aloc_numb]*100+aloc_minute_i[aloc_numb]) <= (aloc_hour_f[free_count]*100+aloc_minute_f[free_count])) {
                                                free = 0;
                                            }
                                        }
                                    }
                                }
                                if(free == 1) {
                                    aloc_status[aloc_numb] = "Em processo de aloca��o";
                                    aloc_thing[aloc_numb] = "Projetor "+questions;
                                } else {
                                    System.out.println("Horario n�o dispon�vel");
                                    aloc_numb--;
                                }
                            }
                        } else if(questions == 2) {
                            System.out.println("Lista de aloca��es:");
                            for(int cont = 1; cont <= aloc_numb; cont++) {
                                if(aloc_man[cont].equals("Pes "+atual)  && aloc_status[cont] == "Alocado") {
                                    System.out.println("� "+cont+" "+aloc_thing[cont]);
                                }
                            }
                            System.out.println("Digite o numero da aloca��o, caso n�o tenha nenhuma ou n�o queira alguma, digite 0");
                            questions = input.nextInt();
                            if(questions != 0) {
                                int aloc2 = questions;
                                int aloc_in = 0;
                                for(int cont = 1; cont <= aloc_numb; cont++) {
                                    if(aloc_man[cont].equals("Pes "+atual) && aloc_status[cont] == "Em Andamento")
                                    {
                                        aloc_in = 1;
                                    }
                                }
                                if(aloc_in == 0) {
                                    System.out.println("Deseja confirmar a aloca��o "+aloc2+"? (1 - Sim / 2 - N�o)");
                                    questions = input.nextInt();
                                    if(questions == 1) {
                                        aloc_status[aloc2] = "Em Andamento";
                                    }
                                } else {
                                    System.out.println("Voc� j� tem uma aloca��o em andamento!");
                                }

                            }
                        } else if(questions == 3) {
                            System.out.println("Lista de aloca��es:");
                            for(int cont = 1; cont <= aloc_numb; cont++) {
                                if(aloc_man[cont].equals("Pes "+atual) && aloc_status[cont] == "Em Andamento") {
                                    System.out.println("� "+cont+" "+aloc_thing[cont]);
                                }
                            }
                            System.out.println("Digite o numero da aloca��o, caso n�o tenha nenhuma ou n�o queira alguma, digite 0");
                            questions = input.nextInt();
                            if(questions != 0) {
                                System.out.println("Deseja adicionar a atividade a aloca��o"+questions+"? (1 - Sim / 2 - N�o)");
                                int aloc2 = questions;
                                questions = input.nextInt();
                                input.nextLine();
                                if(questions == 1) {
                                    aloc_activity_type[aloc2] = "Apresenta��o";
                                    System.out.println("Digite o titulo da atividade:");
                                    aloc_activity_description[aloc2] = input.nextLine();
                                    System.out.println("Digite a descri��o da atividade:");
                                    aloc_activity_description[aloc2] = input.nextLine();
                                    System.out.println("Digite o link para o material da atividade:");
                                    aloc_activity_description[aloc2] = input.nextLine();
                                    System.out.println("Quantos participantes na atividade?");
                                    aloc_activity_numberpart[aloc2] = input.nextInt();
                                    System.out.println("Atividade cadastrada com sucesso.");
                                    aloc_activity_numb++;
                                }
                            }
                        } else if(questions == 4) {
                            end2 = 1;
                        }
                    }
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("Voc� � um administrador.");
                    System.out.println("J� se cadastrou? (1 - Sim / 2 - N�o)");
                    questions = input.nextInt();
                    if(questions == 2){
                        adm_numb++;
                        System.out.println("Voc� � o administrador "+adm_numb+". Escreva seu nome:");
                        adm_name[adm_numb] = input.next();
                        System.out.println("Escreva seu email:");
                        adm_email[adm_numb] = input.next();
                        System.out.println("Voc� est� cadastrado "+adm_name[adm_numb]+"!");
                        atual = adm_numb;
                    }
                    else {
                        System.out.println("Qual seu n�mero de acesso?");
                        atual = input.nextInt();
                        System.out.println("Bem-vindo de volta "+adm_name[adm_numb]+"!");
                    }
                    while(end2 == 0) {
                        System.out.println("Menu de administrador:");
                        System.out.println("1 - N�mero de usu�rios");
                        System.out.println("2 - N�mero de recursos/aloca��es");
                        System.out.println("3 - N�mero de atividades");
                        System.out.println("4 - Consulta por usu�rio");
                        System.out.println("5 - Consulta por recurso/aloca��o");
                        System.out.println("6 - Concluir aloca��o");
                        System.out.println("7 - Alocar processo de aloca��o");
                        System.out.println("8 - Sair");
                        questions = input.nextInt();
                        if(questions == 1) {
                            int sum = adm_numb+prof_numb+alu_numb+pes_numb;
                            System.out.println("O n�mero de usu�rios do sistema �: "+sum);
                        } else if(questions == 2) {
                            System.out.println("O n�mero total de recursos/aloca��es �: "+aloc_numb);
                            System.out.println("Sendo eles:");
                            int count1 = 0;
                            int count2 = 0;
                            int count3 = 0;
                            int count4 = 0;
                            for(int i = 1; i <= aloc_numb; i++)
                            {
                                if(aloc_status[i] == "Alocado"){
                                    count1++;
                                } else if(aloc_status[i] == "Em Andamento") {
                                    count2++;
                                } else if(aloc_status[i] == "Conclu�do") {
                                    count3++;
                                }else if(aloc_status[i] == "Em processo de aloca��o") {
                                    count4++;
                                }
                            }
                            System.out.println(count4+" do tipo 'Em processo de aloca��o'");
                            System.out.println(count1+" do tipo 'Alocado'");
                            System.out.println(count2+" do tipo 'Em Andamento'");
                            System.out.println(count3+" do tipo 'Conclu�do'");

                        } else if(questions == 3) {
                            System.out.println("O n�mero total de atividades �: "+aloc_activity_numb);
                            System.out.println("Sendo elas:");
                            int count1 = 0;
                            int count2 = 0;
                            int count3 = 0;
                            for(int i = 1; i <= aloc_activity_numb; i++)
                            {
                                if(aloc_activity_type[i] == "Aula tradicional"){
                                    count1++;
                                } else if(aloc_activity_type[i] == "Apresenta��o") {
                                    count2++;
                                } else if(aloc_activity_type[i] == "Laborat�rio") {
                                    count3++;
                                }
                            }
                            System.out.println(count1+" do tipo 'Aula tradicional'");
                            System.out.println(count2+" do tipo 'Apresenta��o'");
                            System.out.println(count3+" do tipo 'Laborat�rio'");

                        } else if(questions == 4) {
                            System.out.println("Qual o seu n�vel de acesso do usu�rio?");
                            System.out.println("(1 - Aluno, 2 - Professor, 3 - Pesquisador)");
                            questions = input.nextInt();
                            if(questions == 1) {
                                System.out.println("Digite o c�digo do aluno");
                                questions = input.nextInt();
                                System.out.println("Informa��es do usu�rio:");
                                System.out.println("Nome: "+alu_name[questions]);
                                System.out.println("E-mail: "+alu_email[questions]);
                                System.out.println("Recursos onde ele � respons�vel:");
                            } else if(questions == 2) {
                                System.out.println("Digite o c�digo do professor");
                                questions = input.nextInt();
                                System.out.println("Informa��es do usu�rio:");
                                System.out.println("Nome: "+prof_name[questions]);
                                System.out.println("E-mail: "+prof_email[questions]);
                                System.out.println("Recursos onde ele � respons�vel:");
                                for(int count = 1; count <= aloc_numb; count++) {
                                    if(aloc_man[count].equals("Prof "+questions)) {
                                        System.out.println("Recurso "+count+" � Informa��es: ");
                                        System.out.println(aloc_status[count]);
                                        System.out.println(aloc_thing[count]);
                                        if(aloc_status[count].equals("Conclu�do")) {
                                            System.out.println(aloc_activity_title[count]);
                                            System.out.println(aloc_activity_material[count]);
                                            System.out.println(aloc_activity_description[count]);
                                            System.out.println(aloc_activity_type[count]);
                                            System.out.println(aloc_activity_numberpart[count]);
                                        }
                                    }
                                }
                            } else if(questions == 3) {
                                System.out.println("Digite o c�digo do pesquisador");
                                questions = input.nextInt();
                                System.out.println("Informa��es do usu�rio:");
                                System.out.println("Nome: "+pes_name[questions]);
                                System.out.println("E-mail: "+pes_email[questions]);
                                System.out.println("Recursos onde ele � respons�vel:");
                                for(int count = 1; count <= aloc_numb; count++) {
                                    if(aloc_man[count].equals("Pes "+questions)) {
                                        System.out.println("Recurso "+count+" � Informa��es: ");
                                        System.out.println(aloc_status[count]);
                                        System.out.println(aloc_thing[count]);
                                        if(aloc_status[count].equals("Conclu�do")) {
                                            System.out.println(aloc_activity_title[count]);
                                            System.out.println(aloc_activity_material[count]);
                                            System.out.println(aloc_activity_description[count]);
                                            System.out.println(aloc_activity_type[count]);
                                            System.out.println(aloc_activity_numberpart[count]);
                                        }
                                    }
                                }
                            }

                        } else if(questions == 5) {
                            System.out.println("Digite o c�digo da aloca��o");
                            questions = input.nextInt();
                            System.out.println("Recurso "+questions+" � Informa��es: ");
                            System.out.println(aloc_status[questions]);
                            System.out.println(aloc_thing[questions]);
                            System.out.println(aloc_man[questions]);
                            if(aloc_status[questions].equals("Conclu�do")) {
                                System.out.println(aloc_activity_title[questions]);
                                System.out.println(aloc_activity_material[questions]);
                                System.out.println(aloc_activity_description[questions]);
                                System.out.println(aloc_activity_type[questions]);
                                System.out.println(aloc_activity_numberpart[questions]);
                            }
                        } else if(questions == 6) {
                            System.out.println("Lista de aloca��es:");
                            for(int cont = 1; cont <= aloc_numb; cont++) {
                                if(aloc_status[cont].equals("Em Andamento")) {
                                    System.out.println("� "+cont+" "+aloc_thing[cont]);
                                }
                            }
                            System.out.println("Digite o numero da aloca��o, caso n�o tenha nenhuma ou n�o queira alguma, digite 0");
                            questions = input.nextInt();
                            if(questions != 0) {
                                int aloc2 = questions;
                                System.out.println("Deseja confirmar a aloca��o "+aloc2+"? (1 - Sim / 2 - N�o)");
                                questions = input.nextInt();
                                if(questions == 1) {
                                    aloc_status[aloc2] = "Conclu�do";
                                }
                            }
                        } else if(questions == 7) {
                            System.out.println("Lista de aloca��es:");
                            for(int cont = 1; cont <= aloc_numb; cont++) {
                                if(aloc_status[cont] == "Em processo de aloca��o") {
                                    System.out.println("� "+cont+" "+aloc_thing[cont]);
                                }
                            }
                            System.out.println("Digite o numero da aloca��o, caso n�o tenha nenhuma ou n�o queira alguma, digite 0");
                            questions = input.nextInt();
                            if(questions != 0) {
                                int aloc2 = questions;
                                System.out.println("Deseja confirmar a aloca��o "+aloc2+"? (1 - Sim / 2 - N�o)");
                                questions = input.nextInt();
                                if(questions == 1) {
                                    aloc_status[aloc2] = "Alocado";
                                }
                            }
                        } else if(questions == 8) {
                            end2 = 1;
                        }
                    }
                    break;
            }
            System.out.println("Voc� deseja sair do sistema? (1 - Sim / 2 - N�o)");
            end = input.nextInt();
            if(end == 2) end = 0;
        }
        input.close();
    }

}