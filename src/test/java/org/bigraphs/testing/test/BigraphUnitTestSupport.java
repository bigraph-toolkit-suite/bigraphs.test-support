package org.bigraphs.testing.test;

import org.bigraphs.framework.core.Bigraph;
import org.bigraphs.framework.core.BigraphFileModelManagement;
import org.bigraphs.framework.core.impl.pure.PureBigraph;
import org.bigraphs.framework.visualization.BigraphGraphvizExporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Supplier;

/**
 * @author Dominik Grzelak
 */
public interface BigraphUnitTestSupport {

    default void eb(Bigraph<?> bigraph, String name, String basePath) {
        eb(bigraph, name, basePath, true);
    }

    default void eb(Bigraph<?> bigraph, String name, String basePath, boolean asTree) {
        try {
            BigraphGraphvizExporter.toPNG(bigraph, asTree, new File(basePath + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default void print(PureBigraph bigraph) {
        try {
            BigraphFileModelManagement.Store.exportAsInstanceModel(bigraph, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default void printMetaModel(PureBigraph bigraph) {
        try {
            BigraphFileModelManagement.Store.exportAsMetaModel(bigraph, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default Supplier<String> createNameSupplier(final String prefix) {
        return new Supplier<>() {
            private int id = 0;

            @Override
            public String get() {
                return prefix + id++;
            }
        };
    }

    default void writeToFile(String content, String filePath) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
