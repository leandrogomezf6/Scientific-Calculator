package scientific_calculator;

import com.formdev.flatlaf.FlatDarkLaf;
import evaluator_expression.Evaluator;

/**
 *
 * @author Leandro Gómez.
 * @version 2.0.0
 */
public class Window extends javax.swing.JFrame {

    private static final String SYNTAX_ERROR = "Syntax ERROR";

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        setTitle("Calculadora Cientifica");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        display = new javax.swing.JTextField();
        btnAc = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSqrt = new javax.swing.JButton();
        btnOpenParenthesis = new javax.swing.JButton();
        btnClosedParenthesis = new javax.swing.JButton();
        btnRound = new javax.swing.JButton();
        btnMultiplication = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnDivision = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btnEquals = new javax.swing.JButton();
        btnAns = new javax.swing.JButton();
        btnNum_0 = new javax.swing.JButton();
        btnNum_1 = new javax.swing.JButton();
        btnNum_2 = new javax.swing.JButton();
        btnPow = new javax.swing.JButton();
        btnNum_6 = new javax.swing.JButton();
        btnNum_9 = new javax.swing.JButton();
        btnNum_5 = new javax.swing.JButton();
        btnNum_4 = new javax.swing.JButton();
        btnNum_8 = new javax.swing.JButton();
        btnNum_7 = new javax.swing.JButton();
        btnNum_3 = new javax.swing.JButton();
        displayResult = new javax.swing.JTextField();
        btnPoint = new javax.swing.JButton();
        btnSin = new javax.swing.JButton();
        btnCos = new javax.swing.JButton();
        btnCsc = new javax.swing.JButton();
        btnTan = new javax.swing.JButton();
        btnSec = new javax.swing.JButton();
        btnAsin = new javax.swing.JButton();
        btnCot = new javax.swing.JButton();
        btnAcos = new javax.swing.JButton();
        btnAtan = new javax.swing.JButton();
        spinDecimals = new javax.swing.JSpinner();
        labelRound = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        display.setFont(new java.awt.Font("Liberation Sans", 0, 26)); // NOI18N
        display.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        btnAc.setBackground(new java.awt.Color(255, 102, 0));
        btnAc.setForeground(new java.awt.Color(255, 255, 255));
        btnAc.setText("AC");
        btnAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(255, 102, 0));
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("DEL");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnSqrt.setForeground(new java.awt.Color(255, 255, 255));
        btnSqrt.setText("√");
        btnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });

        btnOpenParenthesis.setForeground(new java.awt.Color(255, 255, 255));
        btnOpenParenthesis.setText("(");
        btnOpenParenthesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenParenthesisActionPerformed(evt);
            }
        });

        btnClosedParenthesis.setForeground(new java.awt.Color(255, 255, 255));
        btnClosedParenthesis.setText(")");
        btnClosedParenthesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosedParenthesisActionPerformed(evt);
            }
        });

        btnRound.setForeground(new java.awt.Color(255, 255, 255));
        btnRound.setText("≈");
        btnRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoundActionPerformed(evt);
            }
        });

        btnMultiplication.setForeground(new java.awt.Color(255, 255, 255));
        btnMultiplication.setText("x");
        btnMultiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicationActionPerformed(evt);
            }
        });

        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
        btnPlus.setText("+");
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnDivision.setForeground(new java.awt.Color(255, 255, 255));
        btnDivision.setText("÷");
        btnDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivisionActionPerformed(evt);
            }
        });

        btnMinus.setForeground(new java.awt.Color(255, 255, 255));
        btnMinus.setText("-");
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        btnEquals.setBackground(new java.awt.Color(0, 204, 0));
        btnEquals.setForeground(new java.awt.Color(255, 255, 255));
        btnEquals.setText("=");
        btnEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualsActionPerformed(evt);
            }
        });

        btnAns.setForeground(new java.awt.Color(255, 255, 255));
        btnAns.setText("Ans");
        btnAns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsActionPerformed(evt);
            }
        });

        btnNum_0.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_0.setText("0");
        btnNum_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_0ActionPerformed(evt);
            }
        });

        btnNum_1.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_1.setText("1");
        btnNum_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_1ActionPerformed(evt);
            }
        });

        btnNum_2.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_2.setText("2");
        btnNum_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_2ActionPerformed(evt);
            }
        });

        btnPow.setForeground(new java.awt.Color(255, 255, 255));
        btnPow.setText("x^");
        btnPow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowActionPerformed(evt);
            }
        });

        btnNum_6.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_6.setText("6");
        btnNum_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_6ActionPerformed(evt);
            }
        });

        btnNum_9.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_9.setText("9");
        btnNum_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_9ActionPerformed(evt);
            }
        });

        btnNum_5.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_5.setText("5");
        btnNum_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_5ActionPerformed(evt);
            }
        });

        btnNum_4.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_4.setText("4");
        btnNum_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_4ActionPerformed(evt);
            }
        });

        btnNum_8.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_8.setText("8");
        btnNum_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_8ActionPerformed(evt);
            }
        });

        btnNum_7.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_7.setText("7");
        btnNum_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_7ActionPerformed(evt);
            }
        });

        btnNum_3.setForeground(new java.awt.Color(255, 255, 255));
        btnNum_3.setText("3");
        btnNum_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNum_3ActionPerformed(evt);
            }
        });

        displayResult.setEditable(false);
        displayResult.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N

        btnPoint.setForeground(new java.awt.Color(255, 255, 255));
        btnPoint.setText(".");
        btnPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPointActionPerformed(evt);
            }
        });

        btnSin.setForeground(new java.awt.Color(255, 255, 255));
        btnSin.setText("sin");
        btnSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinActionPerformed(evt);
            }
        });

        btnCos.setForeground(new java.awt.Color(255, 255, 255));
        btnCos.setText("cos");
        btnCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCosActionPerformed(evt);
            }
        });

        btnCsc.setForeground(new java.awt.Color(255, 255, 255));
        btnCsc.setText("csc");
        btnCsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCscActionPerformed(evt);
            }
        });

        btnTan.setForeground(new java.awt.Color(255, 255, 255));
        btnTan.setText("tan");
        btnTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTanActionPerformed(evt);
            }
        });

        btnSec.setForeground(new java.awt.Color(255, 255, 255));
        btnSec.setText("sec");
        btnSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecActionPerformed(evt);
            }
        });

        btnAsin.setForeground(new java.awt.Color(255, 255, 255));
        btnAsin.setText("asin");
        btnAsin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsinActionPerformed(evt);
            }
        });

        btnCot.setForeground(new java.awt.Color(255, 255, 255));
        btnCot.setText("cot");
        btnCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotActionPerformed(evt);
            }
        });

        btnAcos.setForeground(new java.awt.Color(255, 255, 255));
        btnAcos.setText("acos");
        btnAcos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcosActionPerformed(evt);
            }
        });

        btnAtan.setForeground(new java.awt.Color(255, 255, 255));
        btnAtan.setText("atan");
        btnAtan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtanActionPerformed(evt);
            }
        });

        spinDecimals.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spinDecimals.setToolTipText("Numero de cifras a redondear.");

        labelRound.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        labelRound.setText("Round");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(display, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(displayResult)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(btnAsin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAcos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAtan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(btnSin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(btnCsc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSec, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCot, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRound, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnOpenParenthesis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClosedParenthesis, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(btnNum_6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNum_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNum_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNum_3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(btnPow, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNum_9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNum_8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNum_7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(labelRound)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinDecimals, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNum_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNum_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNum_0, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAns, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(btnMultiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEquals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayResult, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAc)
                    .addComponent(btnDel)
                    .addComponent(btnClosedParenthesis)
                    .addComponent(btnOpenParenthesis)
                    .addComponent(btnRound)
                    .addComponent(btnSqrt)
                    .addComponent(btnSin)
                    .addComponent(btnCos)
                    .addComponent(btnTan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMultiplication)
                    .addComponent(btnDivision)
                    .addComponent(btnPow)
                    .addComponent(btnNum_9)
                    .addComponent(btnNum_8)
                    .addComponent(btnNum_7)
                    .addComponent(btnCsc)
                    .addComponent(btnSec)
                    .addComponent(btnCot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlus)
                    .addComponent(btnMinus)
                    .addComponent(btnNum_6)
                    .addComponent(btnNum_5)
                    .addComponent(btnNum_4)
                    .addComponent(btnNum_3)
                    .addComponent(btnAsin)
                    .addComponent(btnAcos)
                    .addComponent(btnAtan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEquals)
                    .addComponent(btnAns)
                    .addComponent(btnNum_0)
                    .addComponent(btnNum_1)
                    .addComponent(btnNum_2)
                    .addComponent(btnPoint)
                    .addComponent(spinDecimals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRound))
                .addContainerGap())
        );

        getContentPane().add(panel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNum_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_3ActionPerformed
        addToken('3');
    }//GEN-LAST:event_btnNum_3ActionPerformed

    private void btnNum_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_7ActionPerformed
        addToken('7');
    }//GEN-LAST:event_btnNum_7ActionPerformed

    private void btnNum_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_8ActionPerformed
        addToken('8');
    }//GEN-LAST:event_btnNum_8ActionPerformed

    private void btnNum_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_4ActionPerformed
        addToken('4');
    }//GEN-LAST:event_btnNum_4ActionPerformed

    private void btnNum_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_5ActionPerformed
        addToken('5');
    }//GEN-LAST:event_btnNum_5ActionPerformed

    private void btnNum_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_9ActionPerformed
        addToken('9');
    }//GEN-LAST:event_btnNum_9ActionPerformed

    private void btnNum_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_6ActionPerformed
        addToken('6');
    }//GEN-LAST:event_btnNum_6ActionPerformed

    private void btnPowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowActionPerformed
        addToken('^');
    }//GEN-LAST:event_btnPowActionPerformed

    private void btnNum_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_2ActionPerformed
        addToken('2');
    }//GEN-LAST:event_btnNum_2ActionPerformed

    private void btnNum_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_1ActionPerformed
        addToken('1');
    }//GEN-LAST:event_btnNum_1ActionPerformed

    private void btnNum_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNum_0ActionPerformed
        addToken('0');
    }//GEN-LAST:event_btnNum_0ActionPerformed

    private void btnAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsActionPerformed
        StringBuilder expression = new StringBuilder(display.getText());
        expression.append("Ans");
        display.setText(expression.toString());
    }//GEN-LAST:event_btnAnsActionPerformed

    private void btnEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualsActionPerformed
        String EXPRESSION = display.getText();
        if (!EXPRESSION.isBlank() || !EXPRESSION.isEmpty()) {
            evaluateExpression(EXPRESSION);
        }
    }//GEN-LAST:event_btnEqualsActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        addToken('-');
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisionActionPerformed
        addToken('÷');
    }//GEN-LAST:event_btnDivisionActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        addToken('+');
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnMultiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicationActionPerformed
        addToken('x');
    }//GEN-LAST:event_btnMultiplicationActionPerformed

    private void btnRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoundActionPerformed
        String EXPRESSION = displayResult.getText();
        if (!EXPRESSION.isEmpty() || !EXPRESSION.isBlank()) {
            round(EXPRESSION, (int) spinDecimals.getValue());
        }
    }//GEN-LAST:event_btnRoundActionPerformed

    private void btnClosedParenthesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosedParenthesisActionPerformed
        addToken(')');
    }//GEN-LAST:event_btnClosedParenthesisActionPerformed

    private void btnOpenParenthesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenParenthesisActionPerformed
        addToken('(');
    }//GEN-LAST:event_btnOpenParenthesisActionPerformed

    private void btnSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqrtActionPerformed
        addToken('√');
    }//GEN-LAST:event_btnSqrtActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        String EXPRESSION = display.getText();
        if (!EXPRESSION.isEmpty()) {
            deleteToken(EXPRESSION);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcActionPerformed
        if (!display.getText().isEmpty()) {
            display.setText("");
            displayResult.setText("");
        }
    }//GEN-LAST:event_btnAcActionPerformed

    private void btnPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPointActionPerformed
        addToken('.');
    }//GEN-LAST:event_btnPointActionPerformed

    private void btnSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinActionPerformed
        addFunction("sin(");
    }//GEN-LAST:event_btnSinActionPerformed

    private void btnCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCosActionPerformed
        addFunction("cos(");
    }//GEN-LAST:event_btnCosActionPerformed

    private void btnCscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCscActionPerformed
        addFunction("csc(");
    }//GEN-LAST:event_btnCscActionPerformed

    private void btnTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTanActionPerformed
        addFunction("tan(");
    }//GEN-LAST:event_btnTanActionPerformed

    private void btnSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecActionPerformed
        addFunction("sec(");
    }//GEN-LAST:event_btnSecActionPerformed

    private void btnAsinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsinActionPerformed
        addFunction("arcsin(");
    }//GEN-LAST:event_btnAsinActionPerformed

    private void btnCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotActionPerformed
        addFunction("cot(");
    }//GEN-LAST:event_btnCotActionPerformed

    private void btnAcosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcosActionPerformed
        addFunction("arccos(");
    }//GEN-LAST:event_btnAcosActionPerformed

    private void btnAtanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtanActionPerformed
        addFunction("arctan(");
    }//GEN-LAST:event_btnAtanActionPerformed

    private void addToken(char token) {
        StringBuilder expression = new StringBuilder(display.getText());
        expression.append(token);
        display.setText(expression.toString());
    }
    
    private void addFunction(String function) {
        StringBuilder expression = new StringBuilder(display.getText());
        expression.append(function);
        display.setText(expression.toString());
    }

    private void deleteToken(String expression) {
        StringBuilder newExpression = new StringBuilder(expression);
        newExpression.deleteCharAt(expression.length() - 1);
        display.setText(newExpression.toString());
    }

    private void round(String number, int decimals) {
        try {
            double factor = Math.pow(10, decimals);
            double round = Math.round(Double.parseDouble(number) * factor) / factor;
            displayResult.setText(String.valueOf(round));
        } catch (NumberFormatException e) {
            displayResult.setText(SYNTAX_ERROR);
        }
    }

    private void evaluateExpression(String expression) {
        try {
            Evaluator evaluator = new Evaluator(expression);
            displayResult.setText(String.valueOf(evaluator.evaluateExpression()));
        } catch (Exception e) {
            displayResult.setText(SYNTAX_ERROR);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAc;
    private javax.swing.JButton btnAcos;
    private javax.swing.JButton btnAns;
    private javax.swing.JButton btnAsin;
    private javax.swing.JButton btnAtan;
    private javax.swing.JButton btnClosedParenthesis;
    private javax.swing.JButton btnCos;
    private javax.swing.JButton btnCot;
    private javax.swing.JButton btnCsc;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDivision;
    private javax.swing.JButton btnEquals;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMultiplication;
    private javax.swing.JButton btnNum_0;
    private javax.swing.JButton btnNum_1;
    private javax.swing.JButton btnNum_2;
    private javax.swing.JButton btnNum_3;
    private javax.swing.JButton btnNum_4;
    private javax.swing.JButton btnNum_5;
    private javax.swing.JButton btnNum_6;
    private javax.swing.JButton btnNum_7;
    private javax.swing.JButton btnNum_8;
    private javax.swing.JButton btnNum_9;
    private javax.swing.JButton btnOpenParenthesis;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnPoint;
    private javax.swing.JButton btnPow;
    private javax.swing.JButton btnRound;
    private javax.swing.JButton btnSec;
    private javax.swing.JButton btnSin;
    private javax.swing.JButton btnSqrt;
    private javax.swing.JButton btnTan;
    private javax.swing.JTextField display;
    private javax.swing.JTextField displayResult;
    private javax.swing.JLabel labelRound;
    private javax.swing.JPanel panel;
    private javax.swing.JSpinner spinDecimals;
    // End of variables declaration//GEN-END:variables
}
