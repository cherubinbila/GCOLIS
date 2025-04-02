package Print;

import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class TemplateImpression {

    public void RecuColisTemplate(Livraison livraison, Expediteur expediteur, Destinataire destinataire, Colis colis) throws IOException {

        String path = "recuN" + livraison.getId_livraison() + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfdocument = new PdfDocument(pdfWriter);
        pdfdocument.setDefaultPageSize(PageSize.A5);
        Document document = new Document(pdfdocument);

        Paragraph paragraph = new Paragraph();
        paragraph.add("Recu de colis").setTextAlignment(TextAlignment.CENTER).setFontSize(35);
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.add("Reference : " + String.valueOf(livraison.getId_livraison())).setTextAlignment(TextAlignment.CENTER).setFontSize(22);
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.add(livraison.getDateEnvoi().toString()).setTextAlignment(TextAlignment.CENTER).setFontSize(20);
        document.add(paragraph);

        float[] colWidth = {200, 200};
        Table table = new Table(colWidth);

        table.addCell(new Cell().add(new Paragraph("Nom de l'expediteur")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(expediteur.getNom() + " " + expediteur.getPrenom())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Telephone de l'expediteur")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(expediteur.getTelephone())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Ville de l'expediteur")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(expediteur.getVille())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Nom du destinataire")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(destinataire.getNom() + " " + destinataire.getPrenom())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Telephone du destinataire")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(destinataire.getTelephone())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Ville du destinataire")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(destinataire.getVille())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Type de colis")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(colis.getType())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Poids du colis")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(colis.getPoids())+" KG")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(new Cell().add(new Paragraph("Montant")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(livraison.getPrix())+ " FCFA")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

        document.add(table);

        document.close();
    }

    public void ListeLivraisonTemplate(List<Livraison> livraisons, List<Expediteur> expediteurs, List<Destinataire> destinataires, List<Colis> colis) throws IOException {

        if (livraisons.isEmpty()) {
            System.out.println("La liste des livraisons est vide.");
            return;
        }

        if (livraisons.size() != expediteurs.size() || livraisons.size() != destinataires.size() || livraisons.size() != colis.size()) {
            System.out.println("Les listes doivent être de la même taille.");
            return;
        }


        String date = String.valueOf(new Date(System.currentTimeMillis()));
        String path = "listeLivraison_" + date + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfdocument = new PdfDocument(pdfWriter);
        pdfdocument.setDefaultPageSize(PageSize.A4.rotate());
        Document document = new Document(pdfdocument);

        Paragraph paragraph = new Paragraph();
        paragraph.add("Liste des livraisons").setTextAlignment(TextAlignment.CENTER).setFontSize(35);
        document.add(paragraph);

        Table table = new Table(12);
        //table.setWidth(UnitValue.createPercentValue(100));

        table.addCell(new Cell().add(new Paragraph("ID")));
        table.addCell(new Cell().add(new Paragraph("Nom expediteur")));
        table.addCell(new Cell().add(new Paragraph("Telephone expediteur")));
        table.addCell(new Cell().add(new Paragraph("Nom destinataire")));
        table.addCell(new Cell().add(new Paragraph("Telephone destinataire")));
        table.addCell(new Cell().add(new Paragraph("Ville expediteur")));
        table.addCell(new Cell().add(new Paragraph("Ville destinataire")));
        table.addCell(new Cell().add(new Paragraph("Type colis")));
        table.addCell(new Cell().add(new Paragraph("Poids colis")));
        table.addCell(new Cell().add(new Paragraph("Prix")));
        table.addCell(new Cell().add(new Paragraph("Date expedition")));
        table.addCell(new Cell().add(new Paragraph("date Reception")));

        for (int i = 0; i < livraisons.size(); i++) {

            if (livraisons.get(i) == null || expediteurs.get(i) == null || destinataires.get(i) == null || colis.get(i) == null) {
                System.out.println("Un objet est null.");
                continue;
            }

            Livraison livraison = livraisons.get(i);
            Expediteur expediteur = expediteurs.get(i);
            Destinataire destinataire = destinataires.get(i);
            Colis coliss = colis.get(i);

            table.addCell(new Cell().add(new Paragraph(String.valueOf(livraison.getId_livraison()))));
            table.addCell(new Cell().add(new Paragraph(expediteur.getNom() + " " + expediteur.getPrenom())));
            table.addCell(new Cell().add(new Paragraph(expediteur.getTelephone())));
            table.addCell(new Cell().add(new Paragraph(destinataire.getNom() + " " + destinataire.getPrenom())));
            table.addCell(new Cell().add(new Paragraph(destinataire.getTelephone())));
            table.addCell(new Cell().add(new Paragraph(expediteur.getVille())));
            table.addCell(new Cell().add(new Paragraph(destinataire.getVille())));
            table.addCell(new Cell().add(new Paragraph(coliss.getType())));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(coliss.getPoids()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(livraison.getPrix()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(livraison.getDateEnvoi()))));
            if (livraison.getDateReception() == null) {
                table.addCell(new Cell().add(new Paragraph("En cours")));
            }else {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(livraison.getDateReception()))));
            }
        }

        document.add(table);

        document.close();
    }

}
