package menu;

import constants.VertexConst;
import constants.XMLTag;
import graph.EdgeModel;
import graph.VertexModel;
import graphview.EdgeView;
import graphview.EdgesList;
import graphview.VertexView;
import graphview.WorkingArea;
import mode.ClickVertexListener;
import mode.MoveVertexListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.security.provider.certpath.Vertex;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class XMLFile {
    private Element rootElement;
    private String nameFile;
    private JTabbedPane jtpVkladka;

    public XMLFile(String nameFile, JTabbedPane jtpVkladka) {
        this.nameFile = nameFile;
        this.jtpVkladka = jtpVkladka;
    }

    public void writeFile() throws IOException, TransformerException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document document = builder.newDocument();

        rootElement = document.createElement(XMLTag.GRAPH);
        document.appendChild(rootElement);

        WorkingArea boxDrawing = (WorkingArea)jtpVkladka.getSelectedComponent();
        List<VertexView> vertexs = boxDrawing.getGraphView().getVertexesGraph();

        Element allVertexs = document.createElement(XMLTag.VERTEXS);
        rootElement.appendChild(allVertexs);

        Element allEdges = document.createElement(XMLTag.EDGES);
        rootElement.appendChild(allEdges);

        for (VertexView vertexView : vertexs) {
            Element currentVertex = document.createElement(XMLTag.VERTEX);
            currentVertex.setAttribute(XMLTag.NAMEVERTEX, vertexView.getIdentifier().getText());

            String s = Integer.toString(vertexView.getX());
            currentVertex.setAttribute(XMLTag.ALIGNMENTX, s);
            s = Integer.toString(vertexView.getY());
            currentVertex.setAttribute(XMLTag.ALIGNMENTY, s);
            allVertexs.appendChild(currentVertex);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperties(outFormat);
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(nameFile));
            transformer.transform(source, result);
        }

        EdgesList edges = boxDrawing.getAllEdges();
        int n = edges.getNumberAllEdges();
        for (int i = 0; i < n; i++) {
            EdgeView edge = edges.getEdgesAtIndex(i);
            Element currentEdge = document.createElement(XMLTag.EDGE);
            currentEdge.setAttribute(XMLTag.NAMEEDGE, edge.getIdentifier().getText());

            String s = Integer.toString(edge.getStart().getX());
            currentEdge.setAttribute(XMLTag.STARTALIGNMENTX, s);
            s = Integer.toString(edge.getStart().getY());
            currentEdge.setAttribute(XMLTag.STARTALIGNMENTY, s);
            s = Integer.toString(edge.getFinish().getX());
            currentEdge.setAttribute(XMLTag.FINISHALIGNMENTX, s);
            s = Integer.toString(edge.getFinish().getY());
            currentEdge.setAttribute(XMLTag.FINISHALIGNMENTY, s);
            allEdges.appendChild(currentEdge);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            Properties outFormat = new Properties();
            outFormat.setProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperties(outFormat);
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(nameFile));
            transformer.transform(source, result);
        }
    }

    public void readFile(){
        try {
            File xmlFile = new File(nameFile);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            WorkingArea boxDrawing = (WorkingArea)jtpVkladka.getSelectedComponent();

            NodeList vertexList = document.getElementsByTagName(XMLTag.VERTEX);
            for (int temp = 0; temp < vertexList.getLength(); temp++) {
                Node nNode = vertexList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String nameVertex = eElement.getAttribute(XMLTag.NAMEVERTEX);
                    VertexView vertex = new VertexView(VertexConst.GREY_VERTEX_IMAGE,new JLabel(nameVertex));
                    vertex.addMouseMotionListener(new MoveVertexListener(vertex,boxDrawing));
                    vertex.addMouseListener(new ClickVertexListener(vertex));

                    VertexModel newVertexModel = new VertexModel();
                    vertex.setVertexRoot(newVertexModel);
                    boxDrawing.getGraphView().getGraphRoot().addVertex(newVertexModel);
                    boxDrawing.getGraphView().addVertex(vertex);
                    boxDrawing.add(vertex);
                    boxDrawing.add(vertex.getIdentifier());

                    int x = Integer.parseInt(eElement.getAttribute(XMLTag.ALIGNMENTX));
                    int y = Integer.parseInt(eElement.getAttribute(XMLTag.ALIGNMENTY));

                    vertex.setBounds(x, y, VertexConst.VERTEX_SIZE_X, VertexConst.VERTEX_SIZE_Y);
                    vertex.getIdentifier().setBounds(x + VertexConst.VERTEX_SIZE_X,
                            y + VertexConst.VERTEX_SIZE_Y - 4,
                            VertexConst.FONT_SIZE * nameVertex.length(), VertexConst.FONT_SIZE);

                    boxDrawing.repaint();
                }
            }

            NodeList edgeList = document.getElementsByTagName(XMLTag.EDGE);
            for (int temp = 0; temp < edgeList.getLength(); temp++) {
                Node nNode = edgeList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    EdgeView newEdge = new EdgeView(new JLabel(eElement.getAttribute(XMLTag.NAMEEDGE)));

                    int x1 = Integer.parseInt(eElement.getAttribute(XMLTag.STARTALIGNMENTX));
                    int y1 = Integer.parseInt(eElement.getAttribute(XMLTag.STARTALIGNMENTY));
                    int x2 = Integer.parseInt(eElement.getAttribute(XMLTag.FINISHALIGNMENTX));
                    int y2 = Integer.parseInt(eElement.getAttribute(XMLTag.FINISHALIGNMENTY));
                    int x = Math.min(x1, x2) + Math.abs(x1 - x2) / 2;
                    int y = Math.min(y1, y2) + Math.abs(y1 - y2) / 2;

                    VertexView currentVertex;
                    int n = boxDrawing.getGraphView().getVertexesGraph().size();
                    for (int i = 0; i < n; i++) {
                        currentVertex = boxDrawing.getGraphView().getVertexesGraph().get(i);
                        if (currentVertex.getX() == x1 && currentVertex.getY() == y1){
                            newEdge.setStart(currentVertex);
                        }
                        if (currentVertex.getX() == x2 && currentVertex.getY() == y2){
                            newEdge.setFinish(currentVertex);
                        }
                    }
                    boxDrawing.setCurrentEdge(newEdge);

                    boxDrawing.drawEdge(newEdge);
                    newEdge.getIdentifier().setBounds(x, y, VertexConst.FONT_SIZE * 4, VertexConst.FONT_SIZE);
                    newEdge.getStart().addEdge(newEdge);
                    newEdge.getFinish().addEdge(newEdge);
                    boxDrawing.getAllEdges().addEdges(newEdge);
                    boxDrawing.add(newEdge.getIdentifier());

                    EdgeModel newEdgeModel = new EdgeModel(newEdge.getStart().getVertexRoot(),newEdge.getFinish().getVertexRoot());
                    newEdge.setEdgeRoot(newEdgeModel);
                    newEdge.getStart().getVertexRoot().addEdge(newEdgeModel);
                    newEdge.getFinish().getVertexRoot().addEdge(newEdgeModel);
                    boxDrawing.setCurrentEdge(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

