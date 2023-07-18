/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sudoku_solver;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aditi
 */
public class SudokuFile extends javax.swing.JFrame {

    private String turn="";
    
    private boolean globalFlag=true;
    
    private String solvedBoard [][]={
        {"2","9","8","5","1","6","7","3","4"},
        {"4","1","3","2","7","8","5","6","9"},
        {"7","5","6","3","4","9","1","2","8"},
        {"8","2","1","4","3","5","6","9","7"},
        {"5","3","4","6","9","7","2","8","1"},
        {"9","6","7","1","8","2","3","4","5"},
        {"1","4","2","8","5","3","9","7","6"},
        {"3","7","5","9","6","4","8","1","2"},
        {"6","8","9","7","2","1","4","5","3"}
    };
    
    void AssignTurn(JButton btn){
        S1.setBackground(new Color(204,255,204));
        S1.setForeground(new Color(51,51,0));
        S2.setBackground(new Color(204,255,204));
        S2.setForeground(new Color(51,51,0));
        S3.setBackground(new Color(204,255,204));
        S3.setForeground(new Color(51,51,0));
        S4.setBackground(new Color(204,255,204));
        S4.setForeground(new Color(51,51,0));
        S5.setBackground(new Color(204,255,204));
        S5.setForeground(new Color(51,51,0));
        S6.setBackground(new Color(204,255,204));
        S6.setForeground(new Color(51,51,0));
        S7.setBackground(new Color(204,255,204));
        S7.setForeground(new Color(51,51,0));
        S8.setBackground(new Color(204,255,204));
        S8.setForeground(new Color(51,51,0));
        S9.setBackground(new Color(204,255,204));
        S9.setForeground(new Color(51,51,0));
        
        btn.setBackground(Color.BLUE);
        btn.setForeground(new Color(204,255,255));
    }
    
    private void ResetGame(){
        JButton [] predefinedBtns = {R1C4, R1C7, R1C8, R1C9, R2C1, R2C5, R2C6, R2C7, R2C9, R3C1, R3C3, R3C5, R3C8, R4C5, R4C6, R4C8,
            R5C2, R5C3, R5C7, R5C8, R6C2, R6C4, R6C5, R7C2, R7C5, R7C7, R7C9, R8C1, R8C4, R8C5, R8C9, R9C1, R9C2, R9C3, R9C6};
        
        JButton[] selectionBtns = {S1, S2, S3, S4, S5, S6, S7, S8, S9};
        
        JButton btns[][] = {
            {R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9},
            {R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9},
            {R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9},
            {R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9},
            {R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9},
            {R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9},
            {R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9},
            {R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9},
            {R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9}
        };
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                boolean flag=true;
                for(int k=0;k<predefinedBtns.length;k++)
                {
                    if(btns[i][j] == predefinedBtns[k])
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag)
                {
                    btns[i][j].setText("");
                    btns[i][j].setForeground(Color.black);
                    btns[i][j].setBackground(Color.white);
                }
            }
        }
        
        Solution.setText("Solution");
        globalFlag = true;
        Check.setText("Check Moves");
        if(!turn.equals(""))
        {
            selectionBtns[Integer.parseInt(turn)-1].setBackground(new Color(204,255,204));
            selectionBtns[Integer.parseInt(turn)-1].setForeground(new Color(51,51,0));
            turn = "";
        }
    }
    
    private void SeeSolution()
    {
        JButton [] predefinedBtns = {R1C4, R1C7, R1C8, R1C9, R2C1, R2C5, R2C6, R2C7, R2C9, R3C1, R3C3, R3C5, R3C8, R4C5, R4C6, R4C8,
            R5C2, R5C3, R5C7, R5C8, R6C2, R6C4, R6C5, R7C2, R7C5, R7C7, R7C9, R8C1, R8C4, R8C5, R8C9, R9C1, R9C2, R9C3, R9C6};
        
        JButton btns[][] = {
            {R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9},
            {R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9},
            {R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9},
            {R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9},
            {R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9},
            {R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9},
            {R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9},
            {R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9},
            {R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9}
        };
        
        if(globalFlag)
        {
            globalFlag=false;
            Solution.setText("Hide Solution");
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    boolean flag=true;
                    for(int k=0;k<predefinedBtns.length;k++)
                    {
                        if(btns[i][j] == predefinedBtns[k])
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)
                    {
                        btns[i][j].setText(solvedBoard[i][j]);
                        btns[i][j].setForeground(Color.black);
                        btns[i][j].setBackground(Color.white);
                    }
                }
            }
        }
        else
        {
            Solution.setText("Solution");
            globalFlag=true;
            ResetGame();
        }
    }
    
    private void CheckMoves()
    {
        JButton btns[][] = {
            {R1C1, R1C2, R1C3, R1C4, R1C5, R1C6, R1C7, R1C8, R1C9},
            {R2C1, R2C2, R2C3, R2C4, R2C5, R2C6, R2C7, R2C8, R2C9},
            {R3C1, R3C2, R3C3, R3C4, R3C5, R3C6, R3C7, R3C8, R3C9},
            {R4C1, R4C2, R4C3, R4C4, R4C5, R4C6, R4C7, R4C8, R4C9},
            {R5C1, R5C2, R5C3, R5C4, R5C5, R5C6, R5C7, R5C8, R5C9},
            {R6C1, R6C2, R6C3, R6C4, R6C5, R6C6, R6C7, R6C8, R6C9},
            {R7C1, R7C2, R7C3, R7C4, R7C5, R7C6, R7C7, R7C8, R7C9},
            {R8C1, R8C2, R8C3, R8C4, R8C5, R8C6, R8C7, R8C8, R8C9},
            {R9C1, R9C2, R9C3, R9C4, R9C5, R9C6, R9C7, R9C8, R9C9}
        };
        
        if(globalFlag)
        {
            globalFlag=false;
            Check.setText("Remove Wrong");    
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(btns[i][j].getText() != solvedBoard[i][j]  &&  btns[i][j].getText() !="")
                    {
                        btns[i][j].setBackground(Color.red);
                    }
                }
            }
        }
        else
        {
            Check.setText("Check Moves");
            globalFlag=true;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(btns[i][j].getText() != solvedBoard[i][j]  &&  btns[i][j].getText() !="")
                    {
                        btns[i][j].setBackground(Color.white);
                        btns[i][j].setText("");
                    }
                }
            }         
        }
    }
    
    /**
     * Creates new form SudokuFile
     */
    public SudokuFile() {
        this.getContentPane().setBackground(new Color(0xFFCCFF));
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        initComponents();
        this.setLocation((dim.width/2)-230, (dim.height/2)-340);
        
        ImageIcon logo = new ImageIcon("C:\\Users\\Aditi\\OneDrive\\Documents\\NetBeansProjects\\SUDOKU_Solver\\src\\Resources\\pastime.png");
        setIconImage(logo.getImage());
        
        ResetGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Box1 = new javax.swing.JPanel();
        R1C1 = new javax.swing.JButton();
        R1C2 = new javax.swing.JButton();
        R1C3 = new javax.swing.JButton();
        R2C1 = new javax.swing.JButton();
        R2C2 = new javax.swing.JButton();
        R2C3 = new javax.swing.JButton();
        R3C1 = new javax.swing.JButton();
        R3C2 = new javax.swing.JButton();
        R3C3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        R1C4 = new javax.swing.JButton();
        R1C5 = new javax.swing.JButton();
        R1C6 = new javax.swing.JButton();
        R2C4 = new javax.swing.JButton();
        R2C5 = new javax.swing.JButton();
        R2C6 = new javax.swing.JButton();
        R3C4 = new javax.swing.JButton();
        R3C5 = new javax.swing.JButton();
        R3C6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        R4C1 = new javax.swing.JButton();
        R4C2 = new javax.swing.JButton();
        R4C3 = new javax.swing.JButton();
        R5C1 = new javax.swing.JButton();
        R5C2 = new javax.swing.JButton();
        R5C3 = new javax.swing.JButton();
        R6C1 = new javax.swing.JButton();
        R6C2 = new javax.swing.JButton();
        R6C3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        R4C4 = new javax.swing.JButton();
        R4C5 = new javax.swing.JButton();
        R4C6 = new javax.swing.JButton();
        R5C4 = new javax.swing.JButton();
        R5C5 = new javax.swing.JButton();
        R5C6 = new javax.swing.JButton();
        R6C4 = new javax.swing.JButton();
        R6C5 = new javax.swing.JButton();
        R6C6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        R7C4 = new javax.swing.JButton();
        R7C5 = new javax.swing.JButton();
        R7C6 = new javax.swing.JButton();
        R8C4 = new javax.swing.JButton();
        R8C5 = new javax.swing.JButton();
        R8C6 = new javax.swing.JButton();
        R9C4 = new javax.swing.JButton();
        R9C5 = new javax.swing.JButton();
        R9C6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        R7C1 = new javax.swing.JButton();
        R7C2 = new javax.swing.JButton();
        R7C3 = new javax.swing.JButton();
        R8C1 = new javax.swing.JButton();
        R8C2 = new javax.swing.JButton();
        R8C3 = new javax.swing.JButton();
        R9C1 = new javax.swing.JButton();
        R9C2 = new javax.swing.JButton();
        R9C3 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        R1C7 = new javax.swing.JButton();
        R1C8 = new javax.swing.JButton();
        R1C9 = new javax.swing.JButton();
        R2C7 = new javax.swing.JButton();
        R2C8 = new javax.swing.JButton();
        R2C9 = new javax.swing.JButton();
        R3C7 = new javax.swing.JButton();
        R3C8 = new javax.swing.JButton();
        R3C9 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        R4C7 = new javax.swing.JButton();
        R4C8 = new javax.swing.JButton();
        R4C9 = new javax.swing.JButton();
        R5C7 = new javax.swing.JButton();
        R5C8 = new javax.swing.JButton();
        R5C9 = new javax.swing.JButton();
        R6C7 = new javax.swing.JButton();
        R6C8 = new javax.swing.JButton();
        R6C9 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        R7C7 = new javax.swing.JButton();
        R7C8 = new javax.swing.JButton();
        R7C9 = new javax.swing.JButton();
        R8C7 = new javax.swing.JButton();
        R8C8 = new javax.swing.JButton();
        R8C9 = new javax.swing.JButton();
        R9C7 = new javax.swing.JButton();
        R9C8 = new javax.swing.JButton();
        R9C9 = new javax.swing.JButton();
        S1 = new javax.swing.JButton();
        S2 = new javax.swing.JButton();
        S3 = new javax.swing.JButton();
        S4 = new javax.swing.JButton();
        S5 = new javax.swing.JButton();
        S6 = new javax.swing.JButton();
        S7 = new javax.swing.JButton();
        S8 = new javax.swing.JButton();
        S9 = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Solution = new javax.swing.JButton();
        Check = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku Solver");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        Box1.setBackground(new java.awt.Color(255, 154, 101));
        Box1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Box1.setPreferredSize(new java.awt.Dimension(145, 145));

        R1C1.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C1ActionPerformed(evt);
            }
        });

        R1C2.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C2ActionPerformed(evt);
            }
        });

        R1C3.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R1C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C3ActionPerformed(evt);
            }
        });

        R2C1.setBackground(new java.awt.Color(102, 51, 0));
        R2C1.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R2C1.setForeground(new java.awt.Color(255, 255, 204));
        R2C1.setText("4");
        R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C1ActionPerformed(evt);
            }
        });

        R2C2.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C2ActionPerformed(evt);
            }
        });

        R2C3.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R2C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C3ActionPerformed(evt);
            }
        });

        R3C1.setBackground(new java.awt.Color(102, 51, 0));
        R3C1.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R3C1.setForeground(new java.awt.Color(255, 255, 204));
        R3C1.setText("7");
        R3C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C1ActionPerformed(evt);
            }
        });

        R3C2.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R3C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C2ActionPerformed(evt);
            }
        });

        R3C3.setBackground(new java.awt.Color(102, 51, 0));
        R3C3.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R3C3.setForeground(new java.awt.Color(255, 255, 204));
        R3C3.setText("6");
        R3C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Box1Layout = new javax.swing.GroupLayout(Box1);
        Box1.setLayout(Box1Layout);
        Box1Layout.setHorizontalGroup(
            Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Box1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Box1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Box1Layout.createSequentialGroup()
                        .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Box1Layout.createSequentialGroup()
                                .addComponent(R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Box1Layout.createSequentialGroup()
                                .addComponent(R3C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Box1Layout.setVerticalGroup(
            Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Box1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R1C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R2C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R3C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(145, 145));

        R1C4.setBackground(new java.awt.Color(102, 51, 0));
        R1C4.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R1C4.setForeground(new java.awt.Color(255, 255, 204));
        R1C4.setText("5");
        R1C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C4ActionPerformed(evt);
            }
        });

        R1C5.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R1C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C5ActionPerformed(evt);
            }
        });

        R1C6.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R1C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C6ActionPerformed(evt);
            }
        });

        R2C4.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R2C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C4ActionPerformed(evt);
            }
        });

        R2C5.setBackground(new java.awt.Color(102, 51, 0));
        R2C5.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R2C5.setForeground(new java.awt.Color(255, 255, 204));
        R2C5.setText("7");
        R2C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C5ActionPerformed(evt);
            }
        });

        R2C6.setBackground(new java.awt.Color(102, 51, 0));
        R2C6.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R2C6.setForeground(new java.awt.Color(255, 255, 204));
        R2C6.setText("8");
        R2C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C6ActionPerformed(evt);
            }
        });

        R3C4.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R3C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C4ActionPerformed(evt);
            }
        });

        R3C5.setBackground(new java.awt.Color(102, 51, 0));
        R3C5.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R3C5.setForeground(new java.awt.Color(255, 255, 204));
        R3C5.setText("4");
        R3C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C5ActionPerformed(evt);
            }
        });

        R3C6.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R3C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R2C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(R1C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(R3C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R1C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R2C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R3C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(145, 145));

        R4C1.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R4C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C1ActionPerformed(evt);
            }
        });

        R4C2.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R4C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C2ActionPerformed(evt);
            }
        });

        R4C3.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R4C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C3ActionPerformed(evt);
            }
        });

        R5C1.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R5C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C1ActionPerformed(evt);
            }
        });

        R5C2.setBackground(new java.awt.Color(102, 51, 0));
        R5C2.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R5C2.setForeground(new java.awt.Color(255, 255, 204));
        R5C2.setText("3");
        R5C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C2ActionPerformed(evt);
            }
        });

        R5C3.setBackground(new java.awt.Color(102, 51, 0));
        R5C3.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R5C3.setForeground(new java.awt.Color(255, 255, 204));
        R5C3.setText("4");
        R5C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C3ActionPerformed(evt);
            }
        });

        R6C1.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R6C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C1ActionPerformed(evt);
            }
        });

        R6C2.setBackground(new java.awt.Color(102, 51, 0));
        R6C2.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R6C2.setForeground(new java.awt.Color(255, 255, 204));
        R6C2.setText("6");
        R6C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C2ActionPerformed(evt);
            }
        });

        R6C3.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R6C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R5C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R5C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R5C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(R4C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(R6C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R6C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R6C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R4C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R5C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R5C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R5C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R6C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 154, 101));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(145, 145));

        R4C4.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R4C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C4ActionPerformed(evt);
            }
        });

        R4C5.setBackground(new java.awt.Color(102, 51, 0));
        R4C5.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R4C5.setForeground(new java.awt.Color(255, 255, 204));
        R4C5.setText("3");
        R4C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C5ActionPerformed(evt);
            }
        });

        R4C6.setBackground(new java.awt.Color(102, 51, 0));
        R4C6.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R4C6.setForeground(new java.awt.Color(255, 255, 204));
        R4C6.setText("5");
        R4C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C6ActionPerformed(evt);
            }
        });

        R5C4.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R5C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C4ActionPerformed(evt);
            }
        });

        R5C5.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R5C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C5ActionPerformed(evt);
            }
        });

        R5C6.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R5C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C6ActionPerformed(evt);
            }
        });

        R6C4.setBackground(new java.awt.Color(102, 51, 0));
        R6C4.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R6C4.setForeground(new java.awt.Color(255, 255, 204));
        R6C4.setText("1");
        R6C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C4ActionPerformed(evt);
            }
        });

        R6C5.setBackground(new java.awt.Color(102, 51, 0));
        R6C5.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R6C5.setForeground(new java.awt.Color(255, 255, 204));
        R6C5.setText("8");
        R6C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C5ActionPerformed(evt);
            }
        });

        R6C6.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R6C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R5C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R5C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R5C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(R4C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(R6C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R6C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R6C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R4C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(R5C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(R5C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(R5C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R6C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(145, 145));

        R7C4.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R7C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C4ActionPerformed(evt);
            }
        });

        R7C5.setBackground(new java.awt.Color(102, 51, 0));
        R7C5.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R7C5.setForeground(new java.awt.Color(255, 255, 153));
        R7C5.setText("5");
        R7C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C5ActionPerformed(evt);
            }
        });

        R7C6.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R7C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C6ActionPerformed(evt);
            }
        });

        R8C4.setBackground(new java.awt.Color(102, 51, 0));
        R8C4.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R8C4.setForeground(new java.awt.Color(255, 255, 153));
        R8C4.setText("9");
        R8C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C4ActionPerformed(evt);
            }
        });

        R8C5.setBackground(new java.awt.Color(102, 51, 0));
        R8C5.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R8C5.setForeground(new java.awt.Color(255, 255, 153));
        R8C5.setText("6");
        R8C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C5ActionPerformed(evt);
            }
        });

        R8C6.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R8C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C6ActionPerformed(evt);
            }
        });

        R9C4.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R9C4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C4ActionPerformed(evt);
            }
        });

        R9C5.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R9C5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C5ActionPerformed(evt);
            }
        });

        R9C6.setBackground(new java.awt.Color(102, 51, 0));
        R9C6.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R9C6.setForeground(new java.awt.Color(255, 255, 153));
        R9C6.setText("1");
        R9C6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R8C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R8C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R8C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(R7C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R7C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R7C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(R9C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R9C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R9C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R7C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R7C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R7C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R8C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R8C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R8C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R9C4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R9C5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R9C6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 154, 101));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(145, 145));

        R7C1.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R7C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C1ActionPerformed(evt);
            }
        });

        R7C2.setBackground(new java.awt.Color(102, 51, 0));
        R7C2.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R7C2.setForeground(new java.awt.Color(255, 255, 153));
        R7C2.setText("4");
        R7C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C2ActionPerformed(evt);
            }
        });

        R7C3.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R7C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C3ActionPerformed(evt);
            }
        });

        R8C1.setBackground(new java.awt.Color(102, 51, 0));
        R8C1.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R8C1.setForeground(new java.awt.Color(255, 255, 153));
        R8C1.setText("3");
        R8C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C1ActionPerformed(evt);
            }
        });

        R8C2.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R8C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C2ActionPerformed(evt);
            }
        });

        R8C3.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R8C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C3ActionPerformed(evt);
            }
        });

        R9C1.setBackground(new java.awt.Color(102, 51, 0));
        R9C1.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R9C1.setForeground(new java.awt.Color(255, 255, 153));
        R9C1.setText("6");
        R9C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C1ActionPerformed(evt);
            }
        });

        R9C2.setBackground(new java.awt.Color(102, 51, 0));
        R9C2.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R9C2.setForeground(new java.awt.Color(255, 255, 153));
        R9C2.setText("8");
        R9C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C2ActionPerformed(evt);
            }
        });

        R9C3.setBackground(new java.awt.Color(102, 51, 0));
        R9C3.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R9C3.setForeground(new java.awt.Color(255, 255, 153));
        R9C3.setText("9");
        R9C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R8C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R8C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R8C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(R7C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R7C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R7C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(R9C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R9C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R9C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R7C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R7C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R7C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R8C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R8C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R8C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R9C1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R9C2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R9C3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 154, 101));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(145, 145));

        R1C7.setBackground(new java.awt.Color(102, 51, 0));
        R1C7.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R1C7.setForeground(new java.awt.Color(255, 255, 204));
        R1C7.setText("7");
        R1C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C7ActionPerformed(evt);
            }
        });

        R1C8.setBackground(new java.awt.Color(102, 51, 0));
        R1C8.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R1C8.setForeground(new java.awt.Color(255, 255, 204));
        R1C8.setText("3");
        R1C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C8ActionPerformed(evt);
            }
        });

        R1C9.setBackground(new java.awt.Color(102, 51, 0));
        R1C9.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R1C9.setForeground(new java.awt.Color(255, 255, 204));
        R1C9.setText("4");
        R1C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C9ActionPerformed(evt);
            }
        });

        R2C7.setBackground(new java.awt.Color(102, 51, 0));
        R2C7.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R2C7.setForeground(new java.awt.Color(255, 255, 204));
        R2C7.setText("5");
        R2C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C7ActionPerformed(evt);
            }
        });

        R2C8.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R2C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C8ActionPerformed(evt);
            }
        });

        R2C9.setBackground(new java.awt.Color(102, 51, 0));
        R2C9.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R2C9.setForeground(new java.awt.Color(255, 255, 204));
        R2C9.setText("9");
        R2C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C9ActionPerformed(evt);
            }
        });

        R3C7.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R3C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C7ActionPerformed(evt);
            }
        });

        R3C8.setBackground(new java.awt.Color(102, 51, 0));
        R3C8.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R3C8.setForeground(new java.awt.Color(255, 255, 204));
        R3C8.setText("2");
        R3C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C8ActionPerformed(evt);
            }
        });

        R3C9.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R3C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R2C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R2C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(R1C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R1C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(R3C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R3C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R1C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R1C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R2C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R3C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 153, 153));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setPreferredSize(new java.awt.Dimension(145, 145));

        R4C7.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R4C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C7ActionPerformed(evt);
            }
        });

        R4C8.setBackground(new java.awt.Color(102, 51, 0));
        R4C8.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R4C8.setForeground(new java.awt.Color(255, 255, 204));
        R4C8.setText("9");
        R4C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C8ActionPerformed(evt);
            }
        });

        R4C9.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R4C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C9ActionPerformed(evt);
            }
        });

        R5C7.setBackground(new java.awt.Color(102, 51, 0));
        R5C7.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R5C7.setForeground(new java.awt.Color(255, 255, 204));
        R5C7.setText("2");
        R5C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C7ActionPerformed(evt);
            }
        });

        R5C8.setBackground(new java.awt.Color(102, 51, 0));
        R5C8.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R5C8.setForeground(new java.awt.Color(255, 255, 204));
        R5C8.setText("8");
        R5C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C8ActionPerformed(evt);
            }
        });

        R5C9.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R5C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R5C9ActionPerformed(evt);
            }
        });

        R6C7.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R6C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C7ActionPerformed(evt);
            }
        });

        R6C8.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R6C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C8ActionPerformed(evt);
            }
        });

        R6C9.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R6C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R6C9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R5C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R5C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R5C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(R4C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R4C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(R6C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R6C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R6C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R4C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R5C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R5C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R5C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R6C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 154, 101));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setPreferredSize(new java.awt.Dimension(145, 145));

        R7C7.setBackground(new java.awt.Color(102, 51, 0));
        R7C7.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R7C7.setForeground(new java.awt.Color(255, 255, 204));
        R7C7.setText("9");
        R7C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C7ActionPerformed(evt);
            }
        });

        R7C8.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R7C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C8ActionPerformed(evt);
            }
        });

        R7C9.setBackground(new java.awt.Color(102, 51, 0));
        R7C9.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R7C9.setForeground(new java.awt.Color(255, 255, 204));
        R7C9.setText("6");
        R7C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R7C9ActionPerformed(evt);
            }
        });

        R8C7.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R8C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C7ActionPerformed(evt);
            }
        });

        R8C8.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R8C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C8ActionPerformed(evt);
            }
        });

        R8C9.setBackground(new java.awt.Color(102, 51, 0));
        R8C9.setFont(new java.awt.Font("Tw Cen MT", 1, 17)); // NOI18N
        R8C9.setForeground(new java.awt.Color(255, 255, 204));
        R8C9.setText("2");
        R8C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R8C9ActionPerformed(evt);
            }
        });

        R9C7.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R9C7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C7ActionPerformed(evt);
            }
        });

        R9C8.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R9C8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C8ActionPerformed(evt);
            }
        });

        R9C9.setFont(new java.awt.Font("Tw Cen MT", 0, 17)); // NOI18N
        R9C9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R9C9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(R8C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R8C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(R8C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(R7C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R7C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R7C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(R9C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R9C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R9C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R7C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R7C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R7C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R8C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R8C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R8C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R9C7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R9C8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R9C9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        S1.setBackground(new java.awt.Color(204, 255, 204));
        S1.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S1.setForeground(new java.awt.Color(51, 51, 0));
        S1.setText("1");
        S1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S1ActionPerformed(evt);
            }
        });

        S2.setBackground(new java.awt.Color(204, 255, 204));
        S2.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S2.setForeground(new java.awt.Color(51, 51, 0));
        S2.setText("2");
        S2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S2ActionPerformed(evt);
            }
        });

        S3.setBackground(new java.awt.Color(204, 255, 204));
        S3.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S3.setForeground(new java.awt.Color(51, 51, 0));
        S3.setText("3");
        S3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S3ActionPerformed(evt);
            }
        });

        S4.setBackground(new java.awt.Color(204, 255, 204));
        S4.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S4.setForeground(new java.awt.Color(51, 51, 0));
        S4.setText("4");
        S4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S4ActionPerformed(evt);
            }
        });

        S5.setBackground(new java.awt.Color(204, 255, 204));
        S5.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S5.setForeground(new java.awt.Color(51, 51, 0));
        S5.setText("5");
        S5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S5ActionPerformed(evt);
            }
        });

        S6.setBackground(new java.awt.Color(204, 255, 204));
        S6.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S6.setForeground(new java.awt.Color(51, 51, 0));
        S6.setText("6");
        S6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S6ActionPerformed(evt);
            }
        });

        S7.setBackground(new java.awt.Color(204, 255, 204));
        S7.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S7.setForeground(new java.awt.Color(51, 51, 0));
        S7.setText("7");
        S7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S7ActionPerformed(evt);
            }
        });

        S8.setBackground(new java.awt.Color(204, 255, 204));
        S8.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S8.setForeground(new java.awt.Color(51, 51, 0));
        S8.setText("8");
        S8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S8ActionPerformed(evt);
            }
        });

        S9.setBackground(new java.awt.Color(204, 255, 204));
        S9.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        S9.setForeground(new java.awt.Color(51, 51, 0));
        S9.setText("9");
        S9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S9ActionPerformed(evt);
            }
        });

        Reset.setBackground(new java.awt.Color(0, 0, 255));
        Reset.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        Reset.setForeground(new java.awt.Color(204, 255, 255));
        Reset.setText("Reset");
        Reset.setPreferredSize(new java.awt.Dimension(75, 40));
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(204, 0, 51));
        Exit.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 213, 224));
        Exit.setText("Exit");
        Exit.setMaximumSize(new java.awt.Dimension(75, 40));
        Exit.setMinimumSize(new java.awt.Dimension(75, 40));
        Exit.setPreferredSize(new java.awt.Dimension(75, 25));
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Solution.setBackground(new java.awt.Color(23, 218, 18));
        Solution.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        Solution.setForeground(new java.awt.Color(0, 102, 51));
        Solution.setText("Solution");
        Solution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolutionActionPerformed(evt);
            }
        });

        Check.setBackground(new java.awt.Color(255, 255, 0));
        Check.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        Check.setForeground(new java.awt.Color(102, 51, 0));
        Check.setText("Check Moves");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sudoku solver");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(Solution, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(Check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(S1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(S4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(S7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(S9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(S2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(S8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(S4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Check, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Solution, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void R3C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R3C1ActionPerformed

    private void R3C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C4ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R3C4.setText(turn);
        R3C4.setBackground(Color.white);
    }//GEN-LAST:event_R3C4ActionPerformed

    private void R6C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C1ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R6C1.setText(turn);
        R6C1.setBackground(Color.white);
    }//GEN-LAST:event_R6C1ActionPerformed

    private void R6C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R6C4ActionPerformed

    private void R9C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C4ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R9C4.setText(turn);
        R9C4.setBackground(Color.white);
    }//GEN-LAST:event_R9C4ActionPerformed

    private void R9C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R9C1ActionPerformed

    private void R3C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C7ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R3C7.setText(turn);
        R3C7.setBackground(Color.white);
    }//GEN-LAST:event_R3C7ActionPerformed

    private void R6C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C7ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R6C7.setText(turn);
        R6C7.setBackground(Color.white);
    }//GEN-LAST:event_R6C7ActionPerformed

    private void R9C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C7ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R9C7.setText(turn);
        R9C7.setBackground(Color.white);
    }//GEN-LAST:event_R9C7ActionPerformed

    private void R2C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C9ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R2C9ActionPerformed

    private void R4C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R4C8ActionPerformed

    private void R7C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C8ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R7C8.setText(turn);
        R7C8.setBackground(Color.white);
    }//GEN-LAST:event_R7C8ActionPerformed

    private void R8C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R8C1ActionPerformed

    private void R9C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C8ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R9C8.setText(turn);
        R9C8.setBackground(Color.white);
    }//GEN-LAST:event_R9C8ActionPerformed

    private void R1C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C1ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R1C1.setText(turn);
        R1C1.setBackground(Color.white);
    }//GEN-LAST:event_R1C1ActionPerformed

    private void SolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolutionActionPerformed
        // TODO add your handling code here:
        SeeSolution();
    }//GEN-LAST:event_SolutionActionPerformed

    private void S5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S5ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S5);
        turn = "5";
    }//GEN-LAST:event_S5ActionPerformed

    private void R3C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R3C3ActionPerformed

    private void R5C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R5C3ActionPerformed

    private void R7C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R7C5ActionPerformed

    private void R2C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R2C6ActionPerformed

    private void R6C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R6C5ActionPerformed

    private void R1C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C2ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R1C2.setText(turn);
        R1C2.setBackground(Color.white);
    }//GEN-LAST:event_R1C2ActionPerformed

    private void R1C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C3ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R1C3.setText(turn);
        R1C3.setBackground(Color.white);
    }//GEN-LAST:event_R1C3ActionPerformed

    private void R1C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R1C4ActionPerformed

    private void R1C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C5ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R1C5.setText(turn);
        R1C5.setBackground(Color.white);
    }//GEN-LAST:event_R1C5ActionPerformed

    private void R1C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C6ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R1C6.setText(turn);
        R1C6.setBackground(Color.white);
    }//GEN-LAST:event_R1C6ActionPerformed

    private void R1C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R1C7ActionPerformed

    private void R1C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R1C8ActionPerformed

    private void R1C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C9ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R1C9ActionPerformed

    private void R2C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R2C1ActionPerformed

    private void R2C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C2ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R2C2.setText(turn);
        R2C2.setBackground(Color.white);
    }//GEN-LAST:event_R2C2ActionPerformed

    private void R2C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C3ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R2C3.setText(turn);
        R2C3.setBackground(Color.white);
    }//GEN-LAST:event_R2C3ActionPerformed

    private void R2C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C4ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R2C4.setText(turn);
        R2C4.setBackground(Color.white);
    }//GEN-LAST:event_R2C4ActionPerformed

    private void R2C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R2C5ActionPerformed

    private void R2C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R2C7ActionPerformed

    private void R2C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C8ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R2C8.setText(turn);
        R2C8.setBackground(Color.white);
    }//GEN-LAST:event_R2C8ActionPerformed

    private void R3C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C2ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R3C2.setText(turn);
        R3C2.setBackground(Color.white);
    }//GEN-LAST:event_R3C2ActionPerformed

    private void R3C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R3C5ActionPerformed

    private void R3C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C6ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R3C6.setText(turn);
        R3C6.setBackground(Color.white);
    }//GEN-LAST:event_R3C6ActionPerformed

    private void R3C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R3C8ActionPerformed

    private void R3C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C9ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R3C9.setText(turn);
        R3C9.setBackground(Color.white);
    }//GEN-LAST:event_R3C9ActionPerformed

    private void R4C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C1ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R4C1.setText(turn);
        R4C1.setBackground(Color.white);
    }//GEN-LAST:event_R4C1ActionPerformed

    private void R4C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C2ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R4C2.setText(turn);
        R4C2.setBackground(Color.white);
    }//GEN-LAST:event_R4C2ActionPerformed

    private void R4C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C3ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R4C3.setText(turn);
        R4C3.setBackground(Color.white);
    }//GEN-LAST:event_R4C3ActionPerformed

    private void R4C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C4ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R4C4.setText(turn);
        R4C4.setBackground(Color.white);
    }//GEN-LAST:event_R4C4ActionPerformed

    private void R4C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R4C5ActionPerformed

    private void R4C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R4C6ActionPerformed

    private void R4C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C7ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R4C7.setText(turn);
        R4C7.setBackground(Color.white);
    }//GEN-LAST:event_R4C7ActionPerformed

    private void R4C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C9ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R4C9.setText(turn);
        R4C9.setBackground(Color.white);
    }//GEN-LAST:event_R4C9ActionPerformed

    private void R5C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C1ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R5C1.setText(turn);
        R5C1.setBackground(Color.white);
    }//GEN-LAST:event_R5C1ActionPerformed

    private void R5C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R5C2ActionPerformed

    private void R5C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C4ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R5C4.setText(turn);
        R5C4.setBackground(Color.white);
    }//GEN-LAST:event_R5C4ActionPerformed

    private void R5C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C5ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R5C5.setText(turn);
        R5C5.setBackground(Color.white);
    }//GEN-LAST:event_R5C5ActionPerformed

    private void R5C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C6ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R5C6.setText(turn);
        R5C6.setBackground(Color.white);
    }//GEN-LAST:event_R5C6ActionPerformed

    private void R5C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R5C7ActionPerformed

    private void R5C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C8ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R5C8ActionPerformed

    private void R5C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R5C9ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R5C9.setText(turn);
        R5C9.setBackground(Color.white);
    }//GEN-LAST:event_R5C9ActionPerformed

    private void R6C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R6C2ActionPerformed

    private void R6C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C3ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R6C3.setText(turn);
        R6C3.setBackground(Color.white);
    }//GEN-LAST:event_R6C3ActionPerformed

    private void R6C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C6ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R6C6.setText(turn);
        R6C6.setBackground(Color.white);
    }//GEN-LAST:event_R6C6ActionPerformed

    private void R6C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C8ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R6C8.setText(turn);
        R6C8.setBackground(Color.white);
    }//GEN-LAST:event_R6C8ActionPerformed

    private void R6C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R6C9ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R6C9.setText(turn);
        R6C9.setBackground(Color.white);
    }//GEN-LAST:event_R6C9ActionPerformed

    private void R7C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C1ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R7C1.setText(turn);
        R7C1.setBackground(Color.white);
    }//GEN-LAST:event_R7C1ActionPerformed

    private void R7C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R7C2ActionPerformed

    private void R7C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C3ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R7C3.setText(turn);
        R7C3.setBackground(Color.white);
    }//GEN-LAST:event_R7C3ActionPerformed

    private void R7C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C4ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R7C4.setText(turn);
        R7C4.setBackground(Color.white);
    }//GEN-LAST:event_R7C4ActionPerformed

    private void R7C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C6ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R7C6.setText(turn);
        R7C6.setBackground(Color.white);
    }//GEN-LAST:event_R7C6ActionPerformed

    private void R7C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C7ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R7C7ActionPerformed

    private void R7C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R7C9ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R7C9ActionPerformed

    private void R8C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C2ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R8C2.setText(turn);
        R8C2.setBackground(Color.white);
    }//GEN-LAST:event_R8C2ActionPerformed

    private void R8C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C3ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R8C3.setText(turn);
        R8C3.setBackground(Color.white);
    }//GEN-LAST:event_R8C3ActionPerformed

    private void R8C4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R8C4ActionPerformed

    private void R8C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R8C5ActionPerformed

    private void R8C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C6ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R8C6.setText(turn);
        R8C6.setBackground(Color.white);
    }//GEN-LAST:event_R8C6ActionPerformed

    private void R8C7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C7ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R8C7.setText(turn);
        R8C7.setBackground(Color.white);
    }//GEN-LAST:event_R8C7ActionPerformed

    private void R8C8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C8ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R8C8.setText(turn);
        R8C8.setBackground(Color.white);
    }//GEN-LAST:event_R8C8ActionPerformed

    private void R8C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R8C9ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R8C9ActionPerformed

    private void R9C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R9C2ActionPerformed

    private void R9C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R9C3ActionPerformed

    private void R9C5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C5ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R9C5.setText(turn);
        R9C5.setBackground(Color.white);
    }//GEN-LAST:event_R9C5ActionPerformed

    private void R9C6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This place is already alocated", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_R9C6ActionPerformed

    private void R9C9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R9C9ActionPerformed
        // TODO add your handling code here:
        if(turn.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select any number", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        R9C9.setText(turn);
        R9C9.setBackground(Color.white);
    }//GEN-LAST:event_R9C9ActionPerformed

    private void S1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S1ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S1);
        turn = "1";
    }//GEN-LAST:event_S1ActionPerformed

    private void S2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S2ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S2);
        turn = "2";
    }//GEN-LAST:event_S2ActionPerformed

    private void S3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S3ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S3);
        turn = "3";
    }//GEN-LAST:event_S3ActionPerformed

    private void S4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S4ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S4);
        turn = "4";
    }//GEN-LAST:event_S4ActionPerformed

    private void S6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S6ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S6);
        turn = "6";
    }//GEN-LAST:event_S6ActionPerformed

    private void S7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S7ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S7);
        turn = "7";
    }//GEN-LAST:event_S7ActionPerformed

    private void S8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S8ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S8);
        turn = "8";
    }//GEN-LAST:event_S8ActionPerformed

    private void S9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S9ActionPerformed
        // TODO add your handling code here:
        AssignTurn(S9);
        turn = "9";
    }//GEN-LAST:event_S9ActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"Confirm if you want to reset the game",
                "Sudoku Puzzle",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            ResetGame();
        }
    }//GEN-LAST:event_ResetActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"Confirm if you want to exit!",
                "Sudoku Puzzle",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed
        // TODO add your handling code here:
        CheckMoves();
    }//GEN-LAST:event_CheckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SudokuFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SudokuFile().setVisible(true);
                new HomeFrame(new SudokuFile()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Box1;
    private javax.swing.JButton Check;
    private javax.swing.JButton Exit;
    private javax.swing.JButton R1C1;
    private javax.swing.JButton R1C2;
    private javax.swing.JButton R1C3;
    private javax.swing.JButton R1C4;
    private javax.swing.JButton R1C5;
    private javax.swing.JButton R1C6;
    private javax.swing.JButton R1C7;
    private javax.swing.JButton R1C8;
    private javax.swing.JButton R1C9;
    private javax.swing.JButton R2C1;
    private javax.swing.JButton R2C2;
    private javax.swing.JButton R2C3;
    private javax.swing.JButton R2C4;
    private javax.swing.JButton R2C5;
    private javax.swing.JButton R2C6;
    private javax.swing.JButton R2C7;
    private javax.swing.JButton R2C8;
    private javax.swing.JButton R2C9;
    private javax.swing.JButton R3C1;
    private javax.swing.JButton R3C2;
    private javax.swing.JButton R3C3;
    private javax.swing.JButton R3C4;
    private javax.swing.JButton R3C5;
    private javax.swing.JButton R3C6;
    private javax.swing.JButton R3C7;
    private javax.swing.JButton R3C8;
    private javax.swing.JButton R3C9;
    private javax.swing.JButton R4C1;
    private javax.swing.JButton R4C2;
    private javax.swing.JButton R4C3;
    private javax.swing.JButton R4C4;
    private javax.swing.JButton R4C5;
    private javax.swing.JButton R4C6;
    private javax.swing.JButton R4C7;
    private javax.swing.JButton R4C8;
    private javax.swing.JButton R4C9;
    private javax.swing.JButton R5C1;
    private javax.swing.JButton R5C2;
    private javax.swing.JButton R5C3;
    private javax.swing.JButton R5C4;
    private javax.swing.JButton R5C5;
    private javax.swing.JButton R5C6;
    private javax.swing.JButton R5C7;
    private javax.swing.JButton R5C8;
    private javax.swing.JButton R5C9;
    private javax.swing.JButton R6C1;
    private javax.swing.JButton R6C2;
    private javax.swing.JButton R6C3;
    private javax.swing.JButton R6C4;
    private javax.swing.JButton R6C5;
    private javax.swing.JButton R6C6;
    private javax.swing.JButton R6C7;
    private javax.swing.JButton R6C8;
    private javax.swing.JButton R6C9;
    private javax.swing.JButton R7C1;
    private javax.swing.JButton R7C2;
    private javax.swing.JButton R7C3;
    private javax.swing.JButton R7C4;
    private javax.swing.JButton R7C5;
    private javax.swing.JButton R7C6;
    private javax.swing.JButton R7C7;
    private javax.swing.JButton R7C8;
    private javax.swing.JButton R7C9;
    private javax.swing.JButton R8C1;
    private javax.swing.JButton R8C2;
    private javax.swing.JButton R8C3;
    private javax.swing.JButton R8C4;
    private javax.swing.JButton R8C5;
    private javax.swing.JButton R8C6;
    private javax.swing.JButton R8C7;
    private javax.swing.JButton R8C8;
    private javax.swing.JButton R8C9;
    private javax.swing.JButton R9C1;
    private javax.swing.JButton R9C2;
    private javax.swing.JButton R9C3;
    private javax.swing.JButton R9C4;
    private javax.swing.JButton R9C5;
    private javax.swing.JButton R9C6;
    private javax.swing.JButton R9C7;
    private javax.swing.JButton R9C8;
    private javax.swing.JButton R9C9;
    private javax.swing.JButton Reset;
    private javax.swing.JButton S1;
    private javax.swing.JButton S2;
    private javax.swing.JButton S3;
    private javax.swing.JButton S4;
    private javax.swing.JButton S5;
    private javax.swing.JButton S6;
    private javax.swing.JButton S7;
    private javax.swing.JButton S8;
    private javax.swing.JButton S9;
    private javax.swing.JButton Solution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
