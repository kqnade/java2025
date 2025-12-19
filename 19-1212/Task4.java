import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Task4 extends JFrame implements ActionListener {
    // Enum for Tools
    enum Tool {
        PEN, ERASER, SPRAY, STAMP
    }

    // Inner class for Layer
    class Layer {
        BufferedImage image;
        float opacity = 1.0f;
        String name;
        Stack<BufferedImage> undoStack = new Stack<>();

        public Layer(int width, int height, String name) {
            this.name = name;
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            clear();
        }

        public void clear() {
            Graphics2D g = image.createGraphics();
            g.setComposite(AlphaComposite.Clear);
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            g.dispose();
        }

        public void saveState() {
            BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            Graphics2D g = copy.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            undoStack.push(copy);
            if (undoStack.size() > 20) { // Limit history size
                undoStack.remove(0);
            }
        }

        public void undo() {
            if (!undoStack.isEmpty()) {
                image = undoStack.pop();
            }
        }
    }

    MyPanel drawingPanel;
    
    // Tools UI
    JRadioButton radioPen, radioEraser, radioSpray, radioStamp;
    JCheckBox gaussianCheck;
    JButton colorButton, clearLayerButton, fillLayerButton, addLayerButton, removeLayerButton, undoButton;
    JSlider thicknessSlider, opacitySlider;
    JComboBox<String> layerSelector;
    
    // State
    Color currentColor = Color.BLACK;
    Tool currentTool = Tool.PEN;
    int currentThickness = 5;
    
    // Layer State
    ArrayList<Layer> layers = new ArrayList<>();
    int currentLayerIndex = 0;
    
    public static void main(String[] args) {
        new Task4();
    }

    public Task4() {
        this.setTitle("Task 4: Advanced Drawing");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize Layers
        Layer bgLayer = new Layer(1000, 700, "Background");
        Graphics2D gBg = bgLayer.image.createGraphics();
        gBg.setColor(Color.WHITE);
        gBg.fillRect(0, 0, 1000, 700);
        gBg.dispose();
        layers.add(bgLayer);
        
        layers.add(new Layer(1000, 700, "Layer 1"));
        currentLayerIndex = 1; // Start drawing on Layer 1

        // --- Main Control Panel (North) ---
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        
        // Modified toolPanel to support Left (Tools) and Right (Actions) alignment
        JPanel toolPanel = new JPanel(new BorderLayout());
        JPanel toolLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel toolRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JPanel propertyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Tools
        ButtonGroup toolGroup = new ButtonGroup();
        radioPen = new JRadioButton("Pen", true);
        radioEraser = new JRadioButton("Eraser");
        radioSpray = new JRadioButton("Spray");
        gaussianCheck = new JCheckBox("Gaussian");
        radioStamp = new JRadioButton("Stamp");
        
        toolGroup.add(radioPen);
        toolGroup.add(radioEraser);
        toolGroup.add(radioSpray);
        toolGroup.add(radioStamp);
        
        toolLeftPanel.add(new JLabel("Tools: "));
        toolLeftPanel.add(radioPen);
        toolLeftPanel.add(radioEraser);
        toolLeftPanel.add(radioSpray);
        toolLeftPanel.add(gaussianCheck);
        toolLeftPanel.add(radioStamp);
        
        // Listeners for Tools
        ActionListener toolListener = e -> {
            if (radioPen.isSelected()) currentTool = Tool.PEN;
            else if (radioEraser.isSelected()) currentTool = Tool.ERASER;
            else if (radioSpray.isSelected()) currentTool = Tool.SPRAY;
            else if (radioStamp.isSelected()) currentTool = Tool.STAMP;
        };
        radioPen.addActionListener(toolListener);
        radioEraser.addActionListener(toolListener);
        radioSpray.addActionListener(toolListener);
        radioStamp.addActionListener(toolListener);

        // Color
        colorButton = new JButton("Color Wheel");
        colorButton.setBackground(currentColor);
        colorButton.setForeground(Color.WHITE);
        colorButton.addActionListener(this);
        toolLeftPanel.add(colorButton);

        // --- Moved Undo/Clear to Tool Panel (Right) ---
        clearLayerButton = new JButton("Clear Layer");
        clearLayerButton.addActionListener(this);
        toolRightPanel.add(clearLayerButton);

        undoButton = new JButton("Undo");
        undoButton.addActionListener(this);
        toolRightPanel.add(undoButton);

        // Assemble toolPanel
        toolPanel.add(toolLeftPanel, BorderLayout.WEST);
        toolPanel.add(toolRightPanel, BorderLayout.EAST);

        // Thickness
        propertyPanel.add(new JLabel("Thickness/Size: "));
        thicknessSlider = new JSlider(1, 50, 5);
        thicknessSlider.addChangeListener(e -> currentThickness = thicknessSlider.getValue());
        propertyPanel.add(thicknessSlider);

        // Layer Controls
        propertyPanel.add(new JLabel(" | Layers: "));
        
        layerSelector = new JComboBox<>();
        updateLayerSelector();
        layerSelector.setSelectedIndex(currentLayerIndex);
        layerSelector.addActionListener(e -> {
            if (layerSelector.getSelectedIndex() >= 0) {
                currentLayerIndex = layerSelector.getSelectedIndex();
                // Update opacity slider to match current layer
                opacitySlider.setValue((int)(layers.get(currentLayerIndex).opacity * 100));
                drawingPanel.repaint();
            }
        });
        propertyPanel.add(layerSelector);
        
        addLayerButton = new JButton("+");
        addLayerButton.addActionListener(this);
        propertyPanel.add(addLayerButton);
        
        removeLayerButton = new JButton("-");
        removeLayerButton.addActionListener(this);
        propertyPanel.add(removeLayerButton);

        propertyPanel.add(new JLabel(" Opacity: "));
        opacitySlider = new JSlider(0, 100, 100);
        opacitySlider.addChangeListener(e -> {
            if (currentLayerIndex >= 0 && currentLayerIndex < layers.size()) {
                layers.get(currentLayerIndex).opacity = opacitySlider.getValue() / 100f;
                drawingPanel.repaint();
            }
        });
        propertyPanel.add(opacitySlider);
        
        fillLayerButton = new JButton("Fill");
        fillLayerButton.addActionListener(this);
        propertyPanel.add(fillLayerButton);
        
        // clearLayerButton and undoButton moved to toolPanel

        topPanel.add(toolPanel);
        topPanel.add(propertyPanel);
        this.add(topPanel, BorderLayout.NORTH);

        // --- Drawing Panel (Center) ---
        drawingPanel = new MyPanel();
        this.add(drawingPanel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    private void updateLayerSelector() {
        layerSelector.removeAllItems();
        for (Layer l : layers) {
            layerSelector.addItem(l.name);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            Color newColor = JColorChooser.showDialog(this, "Choose Color", currentColor);
            if (newColor != null) {
                currentColor = newColor;
                colorButton.setBackground(currentColor);
            }
        } else if (e.getSource() == fillLayerButton) {
            if (currentLayerIndex >= 0 && currentLayerIndex < layers.size()) {
                Layer current = layers.get(currentLayerIndex);
                current.saveState(); // Save state before fill
                Graphics2D g = current.image.createGraphics();
                g.setComposite(AlphaComposite.Src);
                g.setColor(currentColor);
                g.fillRect(0, 0, current.image.getWidth(), current.image.getHeight());
                g.dispose();
                drawingPanel.repaint();
            }
        } else if (e.getSource() == clearLayerButton) {
            if (currentLayerIndex >= 0 && currentLayerIndex < layers.size()) {
                layers.get(currentLayerIndex).saveState(); // Save state before clear
                layers.get(currentLayerIndex).clear();
                drawingPanel.repaint();
            }
        } else if (e.getSource() == addLayerButton) {
            layers.add(new Layer(drawingPanel.getWidth(), drawingPanel.getHeight(), "Layer " + layers.size()));
            updateLayerSelector();
            layerSelector.setSelectedIndex(layers.size() - 1);
            drawingPanel.repaint();
        } else if (e.getSource() == removeLayerButton) {
            if (layers.size() > 1) {
                layers.remove(currentLayerIndex);
                if (currentLayerIndex >= layers.size()) currentLayerIndex = layers.size() - 1;
                updateLayerSelector();
                layerSelector.setSelectedIndex(currentLayerIndex);
                drawingPanel.repaint();
            }
        } else if (e.getSource() == undoButton) {
            if (currentLayerIndex >= 0 && currentLayerIndex < layers.size()) {
                layers.get(currentLayerIndex).undo();
                drawingPanel.repaint();
            }
        }
    }

    class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
        private int prev_x, prev_y;

        public MyPanel() {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            this.setBackground(Color.WHITE); // Base canvas color
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Draw Checkered background for transparency visualization
            int gridSize = 20;
            for (int x = 0; x < getWidth(); x += gridSize) {
                for (int y = 0; y < getHeight(); y += gridSize) {
                    if ((x / gridSize + y / gridSize) % 2 == 0) {
                        g2d.setColor(Color.LIGHT_GRAY);
                    } else {
                        g2d.setColor(Color.WHITE);
                    }
                    g2d.fillRect(x, y, gridSize, gridSize);
                }
            }

            // Compose Layers
            for (Layer layer : layers) {
                Composite originalComposite = g2d.getComposite();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, layer.opacity));
                g2d.drawImage(layer.image, 0, 0, null);
                g2d.setComposite(originalComposite);
            }
        }

        // --- Drawing Logic ---
        
        private void draw(int x, int y, boolean isDrag) {
            if (currentLayerIndex < 0 || currentLayerIndex >= layers.size()) return;
            
            Layer activeLayer = layers.get(currentLayerIndex);
            Graphics2D g2 = activeLayer.image.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Setup Stroke
            if (currentTool == Tool.ERASER) {
                g2.setComposite(AlphaComposite.Clear);
                g2.setStroke(new BasicStroke(currentThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            } else {
                g2.setColor(currentColor);
                g2.setStroke(new BasicStroke(currentThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            }

            if (currentTool == Tool.PEN || currentTool == Tool.ERASER) {
                if (isDrag) {
                    g2.drawLine(prev_x, prev_y, x, y);
                } else {
                    g2.fillOval(x - currentThickness/2, y - currentThickness/2, currentThickness, currentThickness);
                }
            } else if (currentTool == Tool.SPRAY) {
                // Spray works best on drag or click
                Random r = new Random();
                int radius = currentThickness * 2;
                int dotCount = currentThickness * 2;
                
                // For Eraser Spray we would need special handling, but here spray is paint only
                g2.setColor(currentColor);
                for (int i = 0; i < dotCount; i++) {
                    int dx, dy;
                    if (gaussianCheck.isSelected()) {
                        // Gaussian distribution
                        double sigma = radius / 3.0;
                        dx = (int) (r.nextGaussian() * sigma);
                        dy = (int) (r.nextGaussian() * sigma);
                    } else {
                        // Uniform distribution
                        dx = r.nextInt(radius * 2) - radius;
                        dy = r.nextInt(radius * 2) - radius;
                    }
                    
                    if (dx*dx + dy*dy <= radius*radius) {
                        g2.fillRect(x + dx, y + dy, 1, 1);
                    }
                }
            } else if (currentTool == Tool.STAMP && !isDrag) {
                // Draw Stamp only on click (not drag)
                drawStar(g2, x, y, currentThickness * 2);
            }
            
            g2.dispose();
            repaint();
            
            prev_x = x;
            prev_y = y;
        }

        private void drawStar(Graphics2D g, int x, int y, int size) {
            int[] xPoints = new int[10];
            int[] yPoints = new int[10];
            double angle = -Math.PI / 2;
            
            for (int i = 0; i < 10; i++) {
                int r = (i % 2 == 0) ? size : size / 2;
                xPoints[i] = x + (int) (Math.cos(angle) * r);
                yPoints[i] = y + (int) (Math.sin(angle) * r);
                angle += Math.PI / 5;
            }
            g.fillPolygon(xPoints, yPoints, 10);
        }

        public void mousePressed(MouseEvent e) {
            // Save state before drawing
            if (currentLayerIndex >= 0 && currentLayerIndex < layers.size()) {
                layers.get(currentLayerIndex).saveState();
            }
            
            prev_x = e.getX();
            prev_y = e.getY();
            draw(e.getX(), e.getY(), false);
        }

        public void mouseDragged(MouseEvent e) {
            if (currentTool != Tool.STAMP) { // Stamps don't drag well
                draw(e.getX(), e.getY(), true);
            }
        }

        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }
}
