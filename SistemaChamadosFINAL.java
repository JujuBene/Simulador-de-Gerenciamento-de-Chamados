import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.Queue;

// ================= CLASSE CHAMADO =================
// Representa um chamado do sistema
class Chamado {
    int id;
    String descricao;
    String usuario;
    int prioridade;

    public Chamado(int id, String d, String u, int p) {
        this.id = id;
        this.descricao = d;
        this.usuario = u;
        this.prioridade = p;
    }
}

// ================= CLASSE USUARIO =================
// LISTA LIGADA será usada para armazenar usuários
class Usuario {
    String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }
}

// ================= ÁRVORE BINÁRIA =================
// Estrutura usada para organizar e buscar chamados pelo ID
class No {
    Chamado c;
    No esq, dir;

    No(Chamado c) {
        this.c = c;
    }
}

class ArvoreBinaria {
    No raiz;

    // Insere chamado na árvore
    void inserir(Chamado c) {
        raiz = inserirRec(raiz, c);
    }

    private No inserirRec(No r, Chamado c) {

        if (r == null)
            return new No(c);

        // Organiza menor para esquerda e maior para direita
        if (c.id < r.c.id)
            r.esq = inserirRec(r.esq, c);
        else
            r.dir = inserirRec(r.dir, c);

        return r;
    }

    // Busca chamado pelo ID
    Chamado buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Chamado buscarRec(No r, int id) {

        if (r == null)
            return null;

        if (r.c.id == id)
            return r.c;

        if (id < r.c.id)
            return buscarRec(r.esq, id);
        else
            return buscarRec(r.dir, id);
    }
}

// ================= SISTEMA PRINCIPAL =================
public class SistemaChamadosFINAL extends JFrame {

    // ================= ESTRUTURAS =================

    // FILA (FIFO)
    // Armazena chamados aguardando atendimento
    Queue<Chamado> fila = new LinkedList<>();

    // PILHA (LIFO)
    // Guarda histórico de chamados atendidos
    Stack<Chamado> historico = new Stack<>();

    // LISTA LIGADA
    // Guarda usuários cadastrados
    LinkedList<Usuario> usuarios = new LinkedList<>();

    // ÁRVORE BINÁRIA
    // Permite busca rápida de chamados por ID
    ArvoreBinaria arvore = new ArvoreBinaria();

    int id = 1;

    DefaultTableModel model;

    public SistemaChamadosFINAL() {

        // ===== CONFIGURAÇÕES DA JANELA =====
        setTitle("Sistema de Chamados");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Fundo azul claro
        getContentPane().setBackground(new Color(220, 235, 255));

        // ===== TÍTULO =====
        JLabel titulo = new JLabel("Sistema de Chamados de Suporte", JLabel.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setForeground(new Color(0, 51, 153));

        add(titulo, BorderLayout.NORTH);

        // ===== TABELA =====
        // Mostra chamados que estão na FILA
        model = new DefaultTableModel(
                new String[]{"ID", "Usuário", "Prioridade", "Descrição"}, 0
        );

        JTable tabela = new JTable(model);

        // ===== ESTILO DA TABELA =====
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(Color.BLACK);
        tabela.setGridColor(new Color(180, 200, 255));
        tabela.setSelectionBackground(new Color(100, 149, 237));
        tabela.setRowHeight(25);

        tabela.getTableHeader().setBackground(new Color(0, 102, 204));
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // ===== PAINEL DOS BOTÕES =====
        JPanel painel = new JPanel(new GridLayout(2, 3, 10, 10));

        painel.setBackground(new Color(173, 216, 230));

        // ===== BOTÕES =====
        JButton b1 = new JButton("Cadastrar Usuário");
        JButton b2 = new JButton("Abrir Chamado");
        JButton b3 = new JButton("Atender Chamado");
        JButton b4 = new JButton("Atualizar Fila");
        JButton b5 = new JButton("Ver Histórico");
        JButton b6 = new JButton("Buscar Chamado");

        // ===== ESTILO DOS BOTÕES =====
        JButton[] botoes = {b1, b2, b3, b4, b5, b6};

        for (JButton b : botoes) {
            b.setBackground(new Color(0, 102, 204));
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            b.setFont(new Font("Arial", Font.BOLD, 13));
        }

        // ===== ADICIONA BOTÕES =====
        painel.add(b1);
        painel.add(b2);
        painel.add(b3);
        painel.add(b4);
        painel.add(b5);
        painel.add(b6);

        add(painel, BorderLayout.SOUTH);

        // ================= AÇÕES =================

        // ===== LISTA LIGADA =====
        // Guarda usuários cadastrados
        b1.addActionListener(e -> {

            String nome = JOptionPane.showInputDialog("Nome do usuário:");

            if (nome != null && !nome.isEmpty()) {

                usuarios.add(new Usuario(nome));

                JOptionPane.showMessageDialog(null,
                        "Usuário cadastrado com sucesso!");
            }
        });

        // ===== ABRIR CHAMADO =====
        b2.addActionListener(e -> {

            if (usuarios.isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Cadastre um usuário primeiro!");

                return;
            }

            // LISTA LIGADA sendo usada
            // Seleciona usuário já cadastrado
            String[] nomes = usuarios.stream()
                    .map(u -> u.nome)
                    .toArray(String[]::new);

            String user = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione o usuário:",
                    "Usuários",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nomes,
                    nomes[0]
            );

            String desc = JOptionPane.showInputDialog("Descrição do problema:");

            int p = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Prioridade:\n1 - Alta\n2 - Média\n3 - Baixa")
            );

            Chamado c = new Chamado(id++, desc, user, p);

            // ===== FILA =====
            // Chamado entra na fila de espera
            fila.add(c);

            // ===== ÁRVORE BINÁRIA =====
            // Chamado é organizado para busca rápida
            arvore.inserir(c);

            atualizarTabela();

            JOptionPane.showMessageDialog(null,
                    "Chamado aberto com sucesso!");
        });

        // ===== ATENDER CHAMADO =====
        b3.addActionListener(e -> {

            if (fila.isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Fila vazia!");

                return;
            }

            // ===== FILA =====
            // Remove o primeiro chamado da fila (FIFO)
            Chamado c = fila.poll();

            // ===== PILHA =====
            // Guarda chamado atendido no histórico
            historico.push(c);

            JOptionPane.showMessageDialog(null,
                    "Chamado atendido!\nID: " + c.id);

            atualizarTabela();
        });

        // ===== ATUALIZAR FILA =====
        b4.addActionListener(e -> atualizarTabela());

        // ===== VER HISTÓRICO =====
        // PILHA sendo usada
        b5.addActionListener(e -> {

            StringBuilder sb = new StringBuilder();

            if (historico.isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Histórico vazio");

                return;
            }

          for (int i = historico.size() - 1; i >= 0; i--) {

    Chamado c = historico.get(i);

    sb.append("ID: ").append(c.id)
            .append("\nUsuário: ").append(c.usuario)
            .append("\nDescrição: ").append(c.descricao)
            .append("\n---------------------------\n");
}

            JOptionPane.showMessageDialog(null, sb.toString());
        });

        // ===== BUSCAR CHAMADO =====
        // ÁRVORE BINÁRIA sendo usada
        b6.addActionListener(e -> {

            int busca = Integer.parseInt(
                    JOptionPane.showInputDialog("Digite o ID:")
            );

            Chamado c = arvore.buscar(busca);

            if (c != null) {

                JOptionPane.showMessageDialog(null,
                        "ID: " + c.id +
                                "\nUsuário: " + c.usuario +
                                "\nDescrição: " + c.descricao);

            } else {

                JOptionPane.showMessageDialog(null,
                        "Chamado não encontrado");
            }
        });

        setVisible(true);
    }

    // ===== ATUALIZA TABELA =====
    // Atualiza visualmente os chamados da FILA
    void atualizarTabela() {

        model.setRowCount(0);

        for (Chamado c : fila) {

            String prioridadeTexto = "";

            if (c.prioridade == 1)
                prioridadeTexto = "Alta";

            else if (c.prioridade == 2)
                prioridadeTexto = "Média";

            else
                prioridadeTexto = "Baixa";

            model.addRow(new Object[]{
                    c.id,
                    c.usuario,
                    prioridadeTexto,
                    c.descricao
            });
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new SistemaChamadosFINAL();
        });
    }
}