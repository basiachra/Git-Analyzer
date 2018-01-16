package app.analysis;

import app.fetch.Fetcher;
import app.structures.CommitDetails;
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
    public AnalysisFactory(Fetcher fetcher){
        this.fetcher = fetcher;
    }

    public File generateFile(AbstractAnalyzerModule module, DateTime from, DateTime to, String committerName) throws Exception {
        System.out.println("Karol");

        for (CommitDetails cd:fetcher.getCommitsFromDateRange(from, to)) {
            System.out.println(cd.getCommitMessage());
        }
        return module.generateFile(fetcher.getCommitsFromDateRange(from, to).stream()
                        .filter(cd -> (committerName == null || committerName.isEmpty()) ||
                                Objects.equals(cd.getAuthorName(), committerName)).collect(Collectors.toList()),
                new GUIDetails(from, to ,committerName));
    }
}
