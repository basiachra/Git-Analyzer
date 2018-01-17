package app.analysis;

import app.fetch.Fetcher;
import app.structures.GUIDetails;
import com.google.inject.Inject;
import org.joda.time.DateTime;

import java.io.File;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Karol on 2018-01-15.
 */
public class AnalysisFactory {
    private final Fetcher fetcher;

    @Inject
    public AnalysisFactory(Fetcher fetcher) {
        this.fetcher = fetcher;
    }

    //mock fetchera
    public File generateFile(AbstractAnalyzerModule module, GUIDetails guiDetails) throws Exception {
        DateTime from = guiDetails.getFrom(), to = guiDetails.getTo();
        String committerName = guiDetails.getCommitterName();

        return module.generateFile(fetcher.getCommitsFromDateRange(from, to).stream()
                        .filter(cd -> (committerName == null || committerName.isEmpty()) ||
                                Objects.equals(cd.getAuthorName(), committerName)).collect(Collectors.toList()),
                guiDetails);
    }
}
