package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits
 * all files in the directory and then moves into the subdirectories.
 *
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

    @Override
    public void explore(File rootDirectory, IFileVisitor visitor) {
        //throw new UnsupportedOperationException("The student has not implemented this method yet.");

        
        /*stocking all our files using the rootDirectory provided, in this method
        we get to exlorer ang go through all the directories and their subdirectories */
        File[] listOfFiles = rootDirectory.listFiles();
        visitor.visit(rootDirectory);

        if (listOfFiles != null) {

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    visitor.visit(file);
                }
            }

            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    explore(file, visitor);
                }

            }

        }
    }
}
