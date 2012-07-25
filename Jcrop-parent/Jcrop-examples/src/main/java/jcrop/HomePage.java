package  jcrop;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.jcrop.Coordinates;
import org.jcrop.CroppableSettings;
import org.jcrop.JcropImage;
import org.jcrop.PreviewSettings;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
	super(parameters);
        add(new JcropImage("example1", new PackageResourceReference(HomePage.class, "example.jpg"), new CroppableSettings()));

        CroppableSettings settings2 = new CroppableSettings();
        settings2.setBgColor("yellow");
        settings2.setBgOpacity(0.2);
        add(new JcropImage("example2", new PackageResourceReference(HomePage.class, "example.jpg"), settings2));

        CroppableSettings settings3 = new CroppableSettings();
        settings3.setBgColor("green");
        settings3.setSelect(new Coordinates(10, 10, 100, 100));
        add(new JcropImage("example3", new PackageResourceReference(HomePage.class, "example.jpg"), settings3));

        CroppableSettings settings4 = new CroppableSettings();
        settings4.setAspectRatio(0.5);
        add(new JcropImage("example4", new PackageResourceReference(HomePage.class, "example.jpg"), settings4));

        CroppableSettings settings5 = new CroppableSettings();
        settings5.setAspectRatio(1);
        settings5.setPreview(new PreviewSettings("preview", 100, 100));
        add(new JcropImage("example5", new PackageResourceReference(HomePage.class, "example.jpg"), settings5));

        CroppableSettings settings6 = new CroppableSettings();
        settings6.setBgColor("blue");
        settings6.setBgOpacity(0.2);
        settings6.setBoxWidth(350);
        add(new JcropImage("example6", new PackageResourceReference(HomePage.class, "example.jpg"), settings6));

         CroppableSettings settings7 = new CroppableSettings();
         settings7.setBgColor("pink");
         settings7.setProvideApiController(true);
         final JcropImage jcropImage7 = new JcropImage("example7", new PackageResourceReference(HomePage.class, "example.jpg"), settings7);

        AjaxLink<Void> setSelectionLink = new AjaxLink<Void>("setSelection") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                jcropImage7.getApiController().setSelection(new Coordinates(0, 0, 50, 50), target);
            }
        };
        add(jcropImage7);
        add(setSelectionLink);
    }
}
