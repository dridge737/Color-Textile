/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_form;

import colortextile_class.*;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Eldridge
 */
public class Preview_form extends javax.swing.JFrame {

    /**
     * Creates new form Preview_form
     */
    public Preview_form() {
        initComponents();
    }
    
    public Preview_form(colortextile_class.production_recipe this_prod)
    {
        initComponents();
        this.des_colorway.setText(this_prod.getColor_name());
        this.des_name.setText(this_prod.getDesign_name());
        this.fab_style.setText(this_prod.getFabric_style());
        
        this.cust_text.setText(this_prod.get_all_customers());
        this.job_text.setText(this_prod.get_all_job_id());
        this.quantity.setText(this_prod.get_all_quantity() +""+ this_prod.get_quantity_sum());
        this.date.setText(this_prod.getDate());
        
        List<Colorway_screen_link_functions> all_colorway = this_prod.getAll_colorways();
        
        for(int interval=0; interval<all_colorway.size(); interval++)
        {
            if(interval==0)
            {
                this.screen1.setText(all_colorway.get(interval).getColorway_name());
                this.kg1.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per1.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name1,
                                    perc1,
                                    kgp1);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name2,
                                    perc2,
                                    kgp2);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name3,
                                    perc3,
                                    kgp3);
                        }
                
            }
            else if(interval==1)
            {
                this.screen2.setText(all_colorway.get(interval).getColorway_name());
                this.kg2.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per2.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name4,
                                    perc4,
                                    kgp4);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name5,
                                    perc5,
                                    kgp5);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name6,
                                    perc6,
                                    kgp6);
                        }
                
            }
            else if(interval==2)
            {
                this.screen3.setText(all_colorway.get(interval).getColorway_name());
                this.kg3.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per3.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name7,
                                    perc7,
                                    kgp7);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name8,
                                    perc8,
                                    kgp8);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name9,
                                    perc9,
                                    kgp9);
                        }
                
            }
            else if(interval==3)
            {
                this.screen4.setText(all_colorway.get(interval).getColorway_name());
                this.kg4.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per4.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name10,
                                    perc10,
                                    kgp10);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name11,
                                    perc11,
                                    kgp11);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name12,
                                    perc12,
                                    kgp12);
                        }
                
            }
            
            else if(interval==4)
            {
                this.screen5.setText(all_colorway.get(interval).getColorway_name());
                this.kg5.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per5.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name13,
                                    perc13,
                                    kgp13);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name14,
                                    perc14,
                                    kgp14);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name15,
                                    perc15,
                                    kgp15);
                        }
                
            }
            else if(interval==5)
            {
                this.screen6.setText(all_colorway.get(interval).getColorway_name());
                this.kg6.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per6.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name16,
                                    perc16,
                                    kgp16);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name17,
                                    perc17,
                                    kgp17);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name18,
                                    perc18,
                                    kgp18);
                        }
                
            }
            else if(interval==6)
            {
                this.screen7.setText(all_colorway.get(interval).getColorway_name());
                this.kg7.setText(Float.toString(all_colorway.get(interval).getWeight_kg()));
                this.bind_per7.setText(Float.toString(all_colorway.get(interval).getBinder()));
                
                List<Pigment_screen_and_colorway> all_color_screen = all_colorway.get(interval).getThis_screens();
                        for(int temp_x=0; temp_x<all_color_screen.size(); temp_x++)
                        {
                            if(temp_x==0)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name19,
                                    perc19,
                                    kgp19);
                            else if(temp_x==1)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name20,
                                    perc20,
                                    kgp20);
                            else if(temp_x==2)
                            this.add_screen_to_textfield(all_color_screen.get(temp_x),
                                    all_color_screen.get(temp_x).compute_kg_prep(all_colorway.get(interval).getWeight_kg()),
                                    pig_name21,
                                    perc21,
                                    kgp21);
                        }
                
            }
           
        }
        //this_prod
    }

    private void add_screen_to_textfield(Pigment_screen_and_colorway this_screen, String kgp, JTextField name, JTextField percentage, JTextField kilograms)
    {
        name.setText(this_screen.getPigment_name());
        kilograms.setText(kgp);
        percentage.setText(Float.toString(this_screen.getPigment_percentage()));
    }
     /**       
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cust_text = new javax.swing.JTextField();
        job_text = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        fab_style = new javax.swing.JTextField();
        des_name = new javax.swing.JTextField();
        des_colorway = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pig_name1 = new javax.swing.JTextField();
        pig_name2 = new javax.swing.JTextField();
        perc1 = new javax.swing.JTextField();
        pig_name3 = new javax.swing.JTextField();
        perc2 = new javax.swing.JTextField();
        perc3 = new javax.swing.JTextField();
        screen1 = new javax.swing.JTextField();
        kg1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        kgp1 = new javax.swing.JTextField();
        kgp2 = new javax.swing.JTextField();
        kgp3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        bind_per1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pig_name4 = new javax.swing.JTextField();
        pig_name5 = new javax.swing.JTextField();
        perc4 = new javax.swing.JTextField();
        pig_name6 = new javax.swing.JTextField();
        perc5 = new javax.swing.JTextField();
        perc6 = new javax.swing.JTextField();
        screen2 = new javax.swing.JTextField();
        kg2 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        kgp4 = new javax.swing.JTextField();
        kgp5 = new javax.swing.JTextField();
        kgp6 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        bind_per2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        pig_name7 = new javax.swing.JTextField();
        pig_name8 = new javax.swing.JTextField();
        perc7 = new javax.swing.JTextField();
        pig_name9 = new javax.swing.JTextField();
        perc8 = new javax.swing.JTextField();
        perc9 = new javax.swing.JTextField();
        screen3 = new javax.swing.JTextField();
        kg3 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        kgp7 = new javax.swing.JTextField();
        kgp8 = new javax.swing.JTextField();
        kgp9 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        bind_per3 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        pig_name10 = new javax.swing.JTextField();
        pig_name11 = new javax.swing.JTextField();
        perc10 = new javax.swing.JTextField();
        pig_name12 = new javax.swing.JTextField();
        perc11 = new javax.swing.JTextField();
        perc12 = new javax.swing.JTextField();
        screen4 = new javax.swing.JTextField();
        kg4 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        kgp10 = new javax.swing.JTextField();
        kgp11 = new javax.swing.JTextField();
        kgp12 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel72 = new javax.swing.JLabel();
        bind_per4 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jSeparator27 = new javax.swing.JSeparator();
        jSeparator28 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jSeparator29 = new javax.swing.JSeparator();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        pig_name13 = new javax.swing.JTextField();
        pig_name14 = new javax.swing.JTextField();
        perc13 = new javax.swing.JTextField();
        pig_name15 = new javax.swing.JTextField();
        perc14 = new javax.swing.JTextField();
        perc15 = new javax.swing.JTextField();
        screen5 = new javax.swing.JTextField();
        kg5 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        kgp13 = new javax.swing.JTextField();
        kgp14 = new javax.swing.JTextField();
        kgp15 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator31 = new javax.swing.JSeparator();
        jLabel86 = new javax.swing.JLabel();
        bind_per5 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jSeparator34 = new javax.swing.JSeparator();
        jSeparator35 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jSeparator36 = new javax.swing.JSeparator();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        pig_name16 = new javax.swing.JTextField();
        pig_name17 = new javax.swing.JTextField();
        perc16 = new javax.swing.JTextField();
        pig_name18 = new javax.swing.JTextField();
        perc17 = new javax.swing.JTextField();
        perc18 = new javax.swing.JTextField();
        screen6 = new javax.swing.JTextField();
        kg6 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        kgp16 = new javax.swing.JTextField();
        kgp17 = new javax.swing.JTextField();
        kgp18 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jSeparator37 = new javax.swing.JSeparator();
        jSeparator38 = new javax.swing.JSeparator();
        jLabel100 = new javax.swing.JLabel();
        bind_per6 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jSeparator39 = new javax.swing.JSeparator();
        jSeparator40 = new javax.swing.JSeparator();
        jSeparator41 = new javax.swing.JSeparator();
        jSeparator42 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jSeparator43 = new javax.swing.JSeparator();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        pig_name19 = new javax.swing.JTextField();
        pig_name20 = new javax.swing.JTextField();
        perc19 = new javax.swing.JTextField();
        pig_name21 = new javax.swing.JTextField();
        perc20 = new javax.swing.JTextField();
        perc21 = new javax.swing.JTextField();
        screen7 = new javax.swing.JTextField();
        kg7 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        kgp19 = new javax.swing.JTextField();
        kgp20 = new javax.swing.JTextField();
        kgp21 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jSeparator44 = new javax.swing.JSeparator();
        jSeparator45 = new javax.swing.JSeparator();
        jLabel114 = new javax.swing.JLabel();
        bind_per7 = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jSeparator46 = new javax.swing.JSeparator();
        jSeparator47 = new javax.swing.JSeparator();
        jSeparator48 = new javax.swing.JSeparator();
        jSeparator49 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        add_order2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setMinimumSize(new java.awt.Dimension(820, 650));
        setName("Print Preview\n"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(77, 76, 76));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Print Preview");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 5, 240, 41);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(530, 10, 125, 32);

        date.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(date);
        date.setBounds(660, 9, 120, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 810, 50);

        jPanel2.setBackground(new java.awt.Color(77, 76, 76));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Customer :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, 90, 32));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Job Order :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 90, 32));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Design Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 45, 125, 32));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Design Colorway :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 82, 125, 32));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fabric Style :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 8, 125, 32));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Quantity :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 90, 32));

        cust_text.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(cust_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 8, 380, 32));

        job_text.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(job_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 45, 380, 32));

        quantity.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 82, 380, 32));

        fab_style.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(fab_style, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 8, 150, 32));

        des_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(des_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 45, 150, 32));

        des_colorway.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(des_colorway, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 82, 150, 32));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 50, 809, 124);

        jScrollPane1.setBackground(new java.awt.Color(77, 76, 76));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(77, 76, 76));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);
        jPanel4.add(jSeparator4);
        jSeparator4.setBounds(80, 165, 710, 10);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Pigment Name :");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(90, 50, 110, 32);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Pigment Name :");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(90, 90, 110, 32);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Pigment Name :");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(90, 130, 110, 32);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Screen Name :");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(64, 8, 101, 32);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Kilograms / KGS:");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(480, 8, 109, 32);

        pig_name1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(pig_name1);
        pig_name1.setBounds(209, 50, 150, 32);

        pig_name2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(pig_name2);
        pig_name2.setBounds(209, 90, 150, 32);

        perc1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(perc1);
        perc1.setBounds(435, 50, 43, 32);

        pig_name3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(pig_name3);
        pig_name3.setBounds(209, 130, 150, 32);

        perc2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(perc2);
        perc2.setBounds(435, 90, 43, 32);

        perc3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(perc3);
        perc3.setBounds(435, 130, 43, 32);

        screen1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(screen1);
        screen1.setBounds(177, 8, 212, 32);

        kg1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(kg1);
        kg1.setBounds(590, 8, 77, 32);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("%");
        jPanel4.add(jLabel26);
        jLabel26.setBounds(488, 50, 11, 32);

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("%");
        jPanel4.add(jLabel27);
        jLabel27.setBounds(488, 90, 11, 32);

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("%");
        jPanel4.add(jLabel28);
        jLabel28.setBounds(450, 173, 11, 32);

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("1");
        jPanel4.add(jLabel29);
        jLabel29.setBounds(10, 50, 50, 160);

        kgp1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(kgp1);
        kgp1.setBounds(560, 50, 43, 32);

        kgp2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(kgp2);
        kgp2.setBounds(560, 90, 43, 32);

        kgp3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(kgp3);
        kgp3.setBounds(560, 130, 43, 32);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("KG/ prep");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(610, 50, 90, 32);

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("KG/ prep");
        jPanel4.add(jLabel31);
        jLabel31.setBounds(610, 130, 100, 32);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("KG/ prep");
        jPanel4.add(jLabel32);
        jLabel32.setBounds(610, 90, 90, 32);
        jPanel4.add(jSeparator5);
        jSeparator5.setBounds(0, 45, 790, 10);
        jPanel4.add(jSeparator6);
        jSeparator6.setBounds(80, 85, 710, 10);

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Binder :");
        jPanel4.add(jLabel33);
        jLabel33.setBounds(320, 173, 51, 32);

        bind_per1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel4.add(bind_per1);
        bind_per1.setBounds(380, 173, 60, 32);

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("%");
        jPanel4.add(jLabel34);
        jLabel34.setBounds(488, 130, 11, 32);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator1);
        jSeparator1.setBounds(530, 45, 10, 120);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator3);
        jSeparator3.setBounds(435, 0, 10, 45);
        jPanel4.add(jSeparator7);
        jSeparator7.setBounds(80, 125, 710, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator2);
        jSeparator2.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 210));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);
        jPanel5.add(jSeparator8);
        jSeparator8.setBounds(80, 165, 710, 10);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Pigment Name :");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(90, 50, 110, 32);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Pigment Name :");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(90, 90, 110, 32);

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Pigment Name :");
        jPanel5.add(jLabel35);
        jLabel35.setBounds(90, 130, 110, 32);

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Screen Name :");
        jPanel5.add(jLabel36);
        jLabel36.setBounds(64, 8, 101, 32);

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Kilograms / KGS:");
        jPanel5.add(jLabel37);
        jLabel37.setBounds(480, 8, 109, 32);

        pig_name4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(pig_name4);
        pig_name4.setBounds(209, 50, 150, 32);

        pig_name5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(pig_name5);
        pig_name5.setBounds(209, 90, 150, 32);

        perc4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(perc4);
        perc4.setBounds(435, 50, 43, 32);

        pig_name6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(pig_name6);
        pig_name6.setBounds(209, 130, 150, 32);

        perc5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(perc5);
        perc5.setBounds(435, 90, 43, 32);

        perc6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(perc6);
        perc6.setBounds(435, 130, 43, 32);

        screen2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(screen2);
        screen2.setBounds(177, 8, 212, 32);

        kg2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(kg2);
        kg2.setBounds(590, 8, 77, 32);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("%");
        jPanel5.add(jLabel38);
        jLabel38.setBounds(488, 50, 11, 32);

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("%");
        jPanel5.add(jLabel39);
        jLabel39.setBounds(488, 90, 11, 32);

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("%");
        jPanel5.add(jLabel40);
        jLabel40.setBounds(450, 173, 11, 32);

        jLabel41.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("2");
        jPanel5.add(jLabel41);
        jLabel41.setBounds(10, 50, 50, 160);

        kgp4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(kgp4);
        kgp4.setBounds(560, 50, 43, 32);

        kgp5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(kgp5);
        kgp5.setBounds(560, 90, 43, 32);

        kgp6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(kgp6);
        kgp6.setBounds(560, 130, 43, 32);

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("KG/ prep");
        jPanel5.add(jLabel42);
        jLabel42.setBounds(610, 50, 90, 32);

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("KG/ prep");
        jPanel5.add(jLabel43);
        jLabel43.setBounds(610, 130, 100, 32);

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("KG/ prep");
        jPanel5.add(jLabel44);
        jLabel44.setBounds(610, 90, 90, 32);
        jPanel5.add(jSeparator9);
        jSeparator9.setBounds(0, 45, 790, 10);
        jPanel5.add(jSeparator10);
        jSeparator10.setBounds(80, 85, 710, 10);

        jLabel45.setBackground(new java.awt.Color(255, 255, 255));
        jLabel45.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Binder :");
        jPanel5.add(jLabel45);
        jLabel45.setBounds(320, 173, 51, 32);

        bind_per2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel5.add(bind_per2);
        bind_per2.setBounds(380, 173, 60, 32);

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("%");
        jPanel5.add(jLabel46);
        jLabel46.setBounds(488, 130, 11, 32);

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator11);
        jSeparator11.setBounds(530, 45, 10, 120);

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator12);
        jSeparator12.setBounds(435, 0, 10, 45);
        jPanel5.add(jSeparator13);
        jSeparator13.setBounds(80, 125, 710, 10);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator14);
        jSeparator14.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 209, 790, 210));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);
        jPanel6.add(jSeparator15);
        jSeparator15.setBounds(80, 165, 710, 10);

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Pigment Name :");
        jPanel6.add(jLabel22);
        jLabel22.setBounds(90, 50, 110, 32);

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Pigment Name :");
        jPanel6.add(jLabel47);
        jLabel47.setBounds(90, 90, 110, 32);

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Pigment Name :");
        jPanel6.add(jLabel48);
        jLabel48.setBounds(90, 130, 110, 32);

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Screen Name :");
        jPanel6.add(jLabel49);
        jLabel49.setBounds(64, 8, 101, 32);

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Kilograms / KGS:");
        jPanel6.add(jLabel50);
        jLabel50.setBounds(480, 8, 109, 32);

        pig_name7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(pig_name7);
        pig_name7.setBounds(209, 50, 150, 32);

        pig_name8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(pig_name8);
        pig_name8.setBounds(209, 90, 150, 32);

        perc7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(perc7);
        perc7.setBounds(435, 50, 43, 32);

        pig_name9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(pig_name9);
        pig_name9.setBounds(209, 130, 150, 32);

        perc8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(perc8);
        perc8.setBounds(435, 90, 43, 32);

        perc9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(perc9);
        perc9.setBounds(435, 130, 43, 32);

        screen3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(screen3);
        screen3.setBounds(177, 8, 212, 32);

        kg3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(kg3);
        kg3.setBounds(590, 8, 77, 32);

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("%");
        jPanel6.add(jLabel51);
        jLabel51.setBounds(488, 50, 11, 32);

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("%");
        jPanel6.add(jLabel52);
        jLabel52.setBounds(488, 90, 11, 32);

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("%");
        jPanel6.add(jLabel53);
        jLabel53.setBounds(450, 173, 11, 32);

        jLabel54.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("3");
        jPanel6.add(jLabel54);
        jLabel54.setBounds(10, 50, 50, 160);

        kgp7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(kgp7);
        kgp7.setBounds(560, 50, 43, 32);

        kgp8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(kgp8);
        kgp8.setBounds(560, 90, 43, 32);

        kgp9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(kgp9);
        kgp9.setBounds(560, 130, 43, 32);

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("KG/ prep");
        jPanel6.add(jLabel55);
        jLabel55.setBounds(610, 50, 90, 32);

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("KG/ prep");
        jPanel6.add(jLabel56);
        jLabel56.setBounds(610, 130, 100, 32);

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("KG/ prep");
        jPanel6.add(jLabel57);
        jLabel57.setBounds(610, 90, 90, 32);
        jPanel6.add(jSeparator16);
        jSeparator16.setBounds(0, 45, 790, 10);
        jPanel6.add(jSeparator17);
        jSeparator17.setBounds(80, 85, 710, 10);

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("Binder :");
        jPanel6.add(jLabel58);
        jLabel58.setBounds(320, 173, 51, 32);

        bind_per3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel6.add(bind_per3);
        bind_per3.setBounds(380, 173, 60, 32);

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("%");
        jPanel6.add(jLabel59);
        jLabel59.setBounds(488, 130, 11, 32);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator18);
        jSeparator18.setBounds(530, 45, 10, 120);

        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator19);
        jSeparator19.setBounds(435, 0, 10, 45);
        jPanel6.add(jSeparator20);
        jSeparator20.setBounds(80, 125, 710, 10);

        jSeparator21.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator21);
        jSeparator21.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 418, 790, 210));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(null);
        jPanel7.add(jSeparator22);
        jSeparator22.setBounds(80, 165, 710, 10);

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Pigment Name :");
        jPanel7.add(jLabel60);
        jLabel60.setBounds(90, 50, 110, 32);

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Pigment Name :");
        jPanel7.add(jLabel61);
        jLabel61.setBounds(90, 90, 110, 32);

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Pigment Name :");
        jPanel7.add(jLabel62);
        jLabel62.setBounds(90, 130, 110, 32);

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Screen Name :");
        jPanel7.add(jLabel63);
        jLabel63.setBounds(64, 8, 101, 32);

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Kilograms / KGS:");
        jPanel7.add(jLabel64);
        jLabel64.setBounds(480, 8, 109, 32);

        pig_name10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(pig_name10);
        pig_name10.setBounds(209, 50, 150, 32);

        pig_name11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(pig_name11);
        pig_name11.setBounds(209, 90, 150, 32);

        perc10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(perc10);
        perc10.setBounds(435, 50, 43, 32);

        pig_name12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(pig_name12);
        pig_name12.setBounds(209, 130, 150, 32);

        perc11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(perc11);
        perc11.setBounds(435, 90, 43, 32);

        perc12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(perc12);
        perc12.setBounds(435, 130, 43, 32);

        screen4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(screen4);
        screen4.setBounds(177, 8, 212, 32);

        kg4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(kg4);
        kg4.setBounds(590, 8, 77, 32);

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("%");
        jPanel7.add(jLabel65);
        jLabel65.setBounds(488, 50, 11, 32);

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("%");
        jPanel7.add(jLabel66);
        jLabel66.setBounds(488, 90, 11, 32);

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("%");
        jPanel7.add(jLabel67);
        jLabel67.setBounds(450, 173, 11, 32);

        jLabel68.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("4");
        jPanel7.add(jLabel68);
        jLabel68.setBounds(10, 50, 50, 160);

        kgp10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(kgp10);
        kgp10.setBounds(560, 50, 43, 32);

        kgp11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(kgp11);
        kgp11.setBounds(560, 90, 43, 32);

        kgp12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(kgp12);
        kgp12.setBounds(560, 130, 43, 32);

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("KG/ prep");
        jPanel7.add(jLabel69);
        jLabel69.setBounds(610, 50, 90, 32);

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("KG/ prep");
        jPanel7.add(jLabel70);
        jLabel70.setBounds(610, 130, 100, 32);

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("KG/ prep");
        jPanel7.add(jLabel71);
        jLabel71.setBounds(610, 90, 90, 32);
        jPanel7.add(jSeparator23);
        jSeparator23.setBounds(0, 45, 790, 10);
        jPanel7.add(jSeparator24);
        jSeparator24.setBounds(80, 85, 710, 10);

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("Binder :");
        jPanel7.add(jLabel72);
        jLabel72.setBounds(320, 173, 51, 32);

        bind_per4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel7.add(bind_per4);
        bind_per4.setBounds(380, 173, 60, 32);

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("%");
        jPanel7.add(jLabel73);
        jLabel73.setBounds(488, 130, 11, 32);

        jSeparator25.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator25);
        jSeparator25.setBounds(530, 45, 10, 120);

        jSeparator26.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator26);
        jSeparator26.setBounds(435, 0, 10, 45);
        jPanel7.add(jSeparator27);
        jSeparator27.setBounds(80, 125, 710, 10);

        jSeparator28.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator28);
        jSeparator28.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 627, 790, 210));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(null);
        jPanel8.add(jSeparator29);
        jSeparator29.setBounds(80, 165, 710, 10);

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Pigment Name :");
        jPanel8.add(jLabel74);
        jLabel74.setBounds(90, 50, 110, 32);

        jLabel75.setBackground(new java.awt.Color(255, 255, 255));
        jLabel75.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("Pigment Name :");
        jPanel8.add(jLabel75);
        jLabel75.setBounds(90, 90, 110, 32);

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Pigment Name :");
        jPanel8.add(jLabel76);
        jLabel76.setBounds(90, 130, 110, 32);

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Screen Name :");
        jPanel8.add(jLabel77);
        jLabel77.setBounds(64, 8, 101, 32);

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Kilograms / KGS:");
        jPanel8.add(jLabel78);
        jLabel78.setBounds(480, 8, 109, 32);

        pig_name13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(pig_name13);
        pig_name13.setBounds(209, 50, 150, 32);

        pig_name14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(pig_name14);
        pig_name14.setBounds(209, 90, 150, 32);

        perc13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(perc13);
        perc13.setBounds(435, 50, 43, 32);

        pig_name15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(pig_name15);
        pig_name15.setBounds(209, 130, 150, 32);

        perc14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(perc14);
        perc14.setBounds(435, 90, 43, 32);

        perc15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(perc15);
        perc15.setBounds(435, 130, 43, 32);

        screen5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(screen5);
        screen5.setBounds(177, 8, 212, 32);

        kg5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(kg5);
        kg5.setBounds(590, 8, 77, 32);

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("%");
        jPanel8.add(jLabel79);
        jLabel79.setBounds(488, 50, 11, 32);

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("%");
        jPanel8.add(jLabel80);
        jLabel80.setBounds(488, 90, 11, 32);

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("%");
        jPanel8.add(jLabel81);
        jLabel81.setBounds(450, 173, 11, 32);

        jLabel82.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("5");
        jPanel8.add(jLabel82);
        jLabel82.setBounds(10, 50, 50, 160);

        kgp13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(kgp13);
        kgp13.setBounds(560, 50, 43, 32);

        kgp14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(kgp14);
        kgp14.setBounds(560, 90, 43, 32);

        kgp15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(kgp15);
        kgp15.setBounds(560, 130, 43, 32);

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("KG/ prep");
        jPanel8.add(jLabel83);
        jLabel83.setBounds(610, 50, 90, 32);

        jLabel84.setBackground(new java.awt.Color(255, 255, 255));
        jLabel84.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("KG/ prep");
        jPanel8.add(jLabel84);
        jLabel84.setBounds(610, 130, 100, 32);

        jLabel85.setBackground(new java.awt.Color(255, 255, 255));
        jLabel85.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("KG/ prep");
        jPanel8.add(jLabel85);
        jLabel85.setBounds(610, 90, 90, 32);
        jPanel8.add(jSeparator30);
        jSeparator30.setBounds(0, 45, 790, 10);
        jPanel8.add(jSeparator31);
        jSeparator31.setBounds(80, 85, 710, 10);

        jLabel86.setBackground(new java.awt.Color(255, 255, 255));
        jLabel86.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel86.setText("Binder :");
        jPanel8.add(jLabel86);
        jLabel86.setBounds(320, 173, 51, 32);

        bind_per5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel8.add(bind_per5);
        bind_per5.setBounds(380, 173, 60, 32);

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("%");
        jPanel8.add(jLabel87);
        jLabel87.setBounds(488, 130, 11, 32);

        jSeparator32.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator32);
        jSeparator32.setBounds(530, 45, 10, 120);

        jSeparator33.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator33);
        jSeparator33.setBounds(435, 0, 10, 45);
        jPanel8.add(jSeparator34);
        jSeparator34.setBounds(80, 125, 710, 10);

        jSeparator35.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator35);
        jSeparator35.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 836, 790, 210));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(null);
        jPanel9.add(jSeparator36);
        jSeparator36.setBounds(80, 165, 710, 10);

        jLabel88.setBackground(new java.awt.Color(255, 255, 255));
        jLabel88.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Pigment Name :");
        jPanel9.add(jLabel88);
        jLabel88.setBounds(90, 50, 110, 32);

        jLabel89.setBackground(new java.awt.Color(255, 255, 255));
        jLabel89.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Pigment Name :");
        jPanel9.add(jLabel89);
        jLabel89.setBounds(90, 90, 110, 32);

        jLabel90.setBackground(new java.awt.Color(255, 255, 255));
        jLabel90.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Pigment Name :");
        jPanel9.add(jLabel90);
        jLabel90.setBounds(90, 130, 110, 32);

        jLabel91.setBackground(new java.awt.Color(255, 255, 255));
        jLabel91.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Screen Name :");
        jPanel9.add(jLabel91);
        jLabel91.setBounds(64, 8, 101, 32);

        jLabel92.setBackground(new java.awt.Color(255, 255, 255));
        jLabel92.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Kilograms / KGS:");
        jPanel9.add(jLabel92);
        jLabel92.setBounds(480, 8, 109, 32);

        pig_name16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(pig_name16);
        pig_name16.setBounds(209, 50, 150, 32);

        pig_name17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(pig_name17);
        pig_name17.setBounds(209, 90, 150, 32);

        perc16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(perc16);
        perc16.setBounds(435, 50, 43, 32);

        pig_name18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(pig_name18);
        pig_name18.setBounds(209, 130, 150, 32);

        perc17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(perc17);
        perc17.setBounds(435, 90, 43, 32);

        perc18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(perc18);
        perc18.setBounds(435, 130, 43, 32);

        screen6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(screen6);
        screen6.setBounds(177, 8, 212, 32);

        kg6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(kg6);
        kg6.setBounds(590, 8, 77, 32);

        jLabel93.setBackground(new java.awt.Color(255, 255, 255));
        jLabel93.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("%");
        jPanel9.add(jLabel93);
        jLabel93.setBounds(488, 50, 11, 32);

        jLabel94.setBackground(new java.awt.Color(255, 255, 255));
        jLabel94.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("%");
        jPanel9.add(jLabel94);
        jLabel94.setBounds(488, 90, 11, 32);

        jLabel95.setBackground(new java.awt.Color(255, 255, 255));
        jLabel95.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("%");
        jPanel9.add(jLabel95);
        jLabel95.setBounds(450, 173, 11, 32);

        jLabel96.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("6");
        jPanel9.add(jLabel96);
        jLabel96.setBounds(10, 50, 50, 160);

        kgp16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(kgp16);
        kgp16.setBounds(560, 50, 43, 32);

        kgp17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(kgp17);
        kgp17.setBounds(560, 90, 43, 32);

        kgp18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(kgp18);
        kgp18.setBounds(560, 130, 43, 32);

        jLabel97.setBackground(new java.awt.Color(255, 255, 255));
        jLabel97.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("KG/ prep");
        jPanel9.add(jLabel97);
        jLabel97.setBounds(610, 50, 90, 32);

        jLabel98.setBackground(new java.awt.Color(255, 255, 255));
        jLabel98.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("KG/ prep");
        jPanel9.add(jLabel98);
        jLabel98.setBounds(610, 130, 100, 32);

        jLabel99.setBackground(new java.awt.Color(255, 255, 255));
        jLabel99.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("KG/ prep");
        jPanel9.add(jLabel99);
        jLabel99.setBounds(610, 90, 90, 32);
        jPanel9.add(jSeparator37);
        jSeparator37.setBounds(0, 45, 790, 10);
        jPanel9.add(jSeparator38);
        jSeparator38.setBounds(80, 85, 710, 10);

        jLabel100.setBackground(new java.awt.Color(255, 255, 255));
        jLabel100.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel100.setText("Binder :");
        jPanel9.add(jLabel100);
        jLabel100.setBounds(320, 173, 51, 32);

        bind_per6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel9.add(bind_per6);
        bind_per6.setBounds(380, 173, 60, 32);

        jLabel101.setBackground(new java.awt.Color(255, 255, 255));
        jLabel101.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("%");
        jPanel9.add(jLabel101);
        jLabel101.setBounds(488, 130, 11, 32);

        jSeparator39.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator39);
        jSeparator39.setBounds(530, 45, 10, 120);

        jSeparator40.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator40);
        jSeparator40.setBounds(435, 0, 10, 45);
        jPanel9.add(jSeparator41);
        jSeparator41.setBounds(80, 125, 710, 10);

        jSeparator42.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator42);
        jSeparator42.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1045, 790, 210));

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel10.setOpaque(false);
        jPanel10.setLayout(null);
        jPanel10.add(jSeparator43);
        jSeparator43.setBounds(80, 165, 710, 10);

        jLabel102.setBackground(new java.awt.Color(255, 255, 255));
        jLabel102.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Pigment Name :");
        jPanel10.add(jLabel102);
        jLabel102.setBounds(90, 50, 110, 32);

        jLabel103.setBackground(new java.awt.Color(255, 255, 255));
        jLabel103.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Pigment Name :");
        jPanel10.add(jLabel103);
        jLabel103.setBounds(90, 90, 110, 32);

        jLabel104.setBackground(new java.awt.Color(255, 255, 255));
        jLabel104.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setText("Pigment Name :");
        jPanel10.add(jLabel104);
        jLabel104.setBounds(90, 130, 110, 32);

        jLabel105.setBackground(new java.awt.Color(255, 255, 255));
        jLabel105.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Screen Name :");
        jPanel10.add(jLabel105);
        jLabel105.setBounds(64, 8, 101, 32);

        jLabel106.setBackground(new java.awt.Color(255, 255, 255));
        jLabel106.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("Kilograms / KGS:");
        jPanel10.add(jLabel106);
        jLabel106.setBounds(480, 8, 109, 32);

        pig_name19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(pig_name19);
        pig_name19.setBounds(209, 50, 150, 32);

        pig_name20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(pig_name20);
        pig_name20.setBounds(209, 90, 150, 32);

        perc19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(perc19);
        perc19.setBounds(435, 50, 43, 32);

        pig_name21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(pig_name21);
        pig_name21.setBounds(209, 130, 150, 32);

        perc20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(perc20);
        perc20.setBounds(435, 90, 43, 32);

        perc21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(perc21);
        perc21.setBounds(435, 130, 43, 32);

        screen7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(screen7);
        screen7.setBounds(177, 8, 212, 32);

        kg7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(kg7);
        kg7.setBounds(590, 8, 77, 32);

        jLabel107.setBackground(new java.awt.Color(255, 255, 255));
        jLabel107.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setText("%");
        jPanel10.add(jLabel107);
        jLabel107.setBounds(488, 50, 11, 32);

        jLabel108.setBackground(new java.awt.Color(255, 255, 255));
        jLabel108.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("%");
        jPanel10.add(jLabel108);
        jLabel108.setBounds(488, 90, 11, 32);

        jLabel109.setBackground(new java.awt.Color(255, 255, 255));
        jLabel109.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("%");
        jPanel10.add(jLabel109);
        jLabel109.setBounds(450, 173, 11, 32);

        jLabel110.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("7");
        jPanel10.add(jLabel110);
        jLabel110.setBounds(10, 50, 50, 160);

        kgp19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(kgp19);
        kgp19.setBounds(560, 50, 43, 32);

        kgp20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(kgp20);
        kgp20.setBounds(560, 90, 43, 32);

        kgp21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(kgp21);
        kgp21.setBounds(560, 130, 43, 32);

        jLabel111.setBackground(new java.awt.Color(255, 255, 255));
        jLabel111.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("KG/ prep");
        jPanel10.add(jLabel111);
        jLabel111.setBounds(610, 50, 90, 32);

        jLabel112.setBackground(new java.awt.Color(255, 255, 255));
        jLabel112.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setText("KG/ prep");
        jPanel10.add(jLabel112);
        jLabel112.setBounds(610, 130, 100, 32);

        jLabel113.setBackground(new java.awt.Color(255, 255, 255));
        jLabel113.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setText("KG/ prep");
        jPanel10.add(jLabel113);
        jLabel113.setBounds(610, 90, 90, 32);
        jPanel10.add(jSeparator44);
        jSeparator44.setBounds(0, 45, 790, 10);
        jPanel10.add(jSeparator45);
        jSeparator45.setBounds(80, 85, 710, 10);

        jLabel114.setBackground(new java.awt.Color(255, 255, 255));
        jLabel114.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel114.setText("Binder :");
        jPanel10.add(jLabel114);
        jLabel114.setBounds(320, 173, 51, 32);

        bind_per7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel10.add(bind_per7);
        bind_per7.setBounds(380, 173, 60, 32);

        jLabel115.setBackground(new java.awt.Color(255, 255, 255));
        jLabel115.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("%");
        jPanel10.add(jLabel115);
        jLabel115.setBounds(488, 130, 11, 32);

        jSeparator46.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel10.add(jSeparator46);
        jSeparator46.setBounds(530, 45, 10, 120);

        jSeparator47.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel10.add(jSeparator47);
        jSeparator47.setBounds(435, 0, 10, 45);
        jPanel10.add(jSeparator48);
        jSeparator48.setBounds(80, 125, 710, 10);

        jSeparator49.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel10.add(jSeparator49);
        jSeparator49.setBounds(390, 45, 10, 120);

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1254, 790, 210));

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(-1, 172, 809, 480);

        jPanel11.setBackground(new java.awt.Color(77, 76, 76));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_order2.setBackground(new java.awt.Color(255, 255, 255));
        add_order2.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        add_order2.setText("Ok");
        add_order2.setToolTipText("");
        add_order2.setOpaque(false);
        add_order2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_order2ActionPerformed(evt);
            }
        });
        jPanel11.add(add_order2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 190, 40));

        getContentPane().add(jPanel11);
        jPanel11.setBounds(0, 650, 810, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_order2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_order2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_add_order2ActionPerformed

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
            java.util.logging.Logger.getLogger(Preview_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preview_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preview_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preview_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preview_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_order2;
    private javax.swing.JTextField bind_per1;
    private javax.swing.JTextField bind_per2;
    private javax.swing.JTextField bind_per3;
    private javax.swing.JTextField bind_per4;
    private javax.swing.JTextField bind_per5;
    private javax.swing.JTextField bind_per6;
    private javax.swing.JTextField bind_per7;
    private javax.swing.JTextField cust_text;
    private javax.swing.JTextField date;
    private javax.swing.JTextField des_colorway;
    private javax.swing.JTextField des_name;
    private javax.swing.JTextField fab_style;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator38;
    private javax.swing.JSeparator jSeparator39;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator40;
    private javax.swing.JSeparator jSeparator41;
    private javax.swing.JSeparator jSeparator42;
    private javax.swing.JSeparator jSeparator43;
    private javax.swing.JSeparator jSeparator44;
    private javax.swing.JSeparator jSeparator45;
    private javax.swing.JSeparator jSeparator46;
    private javax.swing.JSeparator jSeparator47;
    private javax.swing.JSeparator jSeparator48;
    private javax.swing.JSeparator jSeparator49;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField job_text;
    private javax.swing.JTextField kg1;
    private javax.swing.JTextField kg2;
    private javax.swing.JTextField kg3;
    private javax.swing.JTextField kg4;
    private javax.swing.JTextField kg5;
    private javax.swing.JTextField kg6;
    private javax.swing.JTextField kg7;
    private javax.swing.JTextField kgp1;
    private javax.swing.JTextField kgp10;
    private javax.swing.JTextField kgp11;
    private javax.swing.JTextField kgp12;
    private javax.swing.JTextField kgp13;
    private javax.swing.JTextField kgp14;
    private javax.swing.JTextField kgp15;
    private javax.swing.JTextField kgp16;
    private javax.swing.JTextField kgp17;
    private javax.swing.JTextField kgp18;
    private javax.swing.JTextField kgp19;
    private javax.swing.JTextField kgp2;
    private javax.swing.JTextField kgp20;
    private javax.swing.JTextField kgp21;
    private javax.swing.JTextField kgp3;
    private javax.swing.JTextField kgp4;
    private javax.swing.JTextField kgp5;
    private javax.swing.JTextField kgp6;
    private javax.swing.JTextField kgp7;
    private javax.swing.JTextField kgp8;
    private javax.swing.JTextField kgp9;
    private javax.swing.JTextField perc1;
    private javax.swing.JTextField perc10;
    private javax.swing.JTextField perc11;
    private javax.swing.JTextField perc12;
    private javax.swing.JTextField perc13;
    private javax.swing.JTextField perc14;
    private javax.swing.JTextField perc15;
    private javax.swing.JTextField perc16;
    private javax.swing.JTextField perc17;
    private javax.swing.JTextField perc18;
    private javax.swing.JTextField perc19;
    private javax.swing.JTextField perc2;
    private javax.swing.JTextField perc20;
    private javax.swing.JTextField perc21;
    private javax.swing.JTextField perc3;
    private javax.swing.JTextField perc4;
    private javax.swing.JTextField perc5;
    private javax.swing.JTextField perc6;
    private javax.swing.JTextField perc7;
    private javax.swing.JTextField perc8;
    private javax.swing.JTextField perc9;
    private javax.swing.JTextField pig_name1;
    private javax.swing.JTextField pig_name10;
    private javax.swing.JTextField pig_name11;
    private javax.swing.JTextField pig_name12;
    private javax.swing.JTextField pig_name13;
    private javax.swing.JTextField pig_name14;
    private javax.swing.JTextField pig_name15;
    private javax.swing.JTextField pig_name16;
    private javax.swing.JTextField pig_name17;
    private javax.swing.JTextField pig_name18;
    private javax.swing.JTextField pig_name19;
    private javax.swing.JTextField pig_name2;
    private javax.swing.JTextField pig_name20;
    private javax.swing.JTextField pig_name21;
    private javax.swing.JTextField pig_name3;
    private javax.swing.JTextField pig_name4;
    private javax.swing.JTextField pig_name5;
    private javax.swing.JTextField pig_name6;
    private javax.swing.JTextField pig_name7;
    private javax.swing.JTextField pig_name8;
    private javax.swing.JTextField pig_name9;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField screen1;
    private javax.swing.JTextField screen2;
    private javax.swing.JTextField screen3;
    private javax.swing.JTextField screen4;
    private javax.swing.JTextField screen5;
    private javax.swing.JTextField screen6;
    private javax.swing.JTextField screen7;
    // End of variables declaration//GEN-END:variables
}
