package chapter26;

import java.io.File;
import java.text.DecimalFormat;

public class FileSizeSummary {
    private final long maxByte = 1024;
    private final long maxKiloByte = 1024 * 1024;
    private final long maxMegaByte = 1024 * 1024 * 1024;

    public static void main(String[] args) {
        FileSizeSummary sample = new FileSizeSummary();
        String path = "/Users/i960107/IdeaProjects/godofjava/chapter10";
        long sum = sample.getDirectorySize(path);
        System.out.println(path + "'s total size = " + sample.convertFileLength(sum));
    }

    public long getDirectorySize(String dirName) {
        File dir = new File(dirName);
        long sum = 0;

        if (!dir.isDirectory()) {
            return sum;
        }

        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                long size = file.getAbsoluteFile().length();
                System.out.println(file.getName() + " size = " + convertFileLength(size));
                sum += size;
            } else {
                long dirSize = getDirectorySize(file.getAbsolutePath());
                System.out.println("[" + file.getName() + "]" + " size = " + convertFileLength(dirSize));
                sum += dirSize;
            }
        }
        return sum;

    }

    private String convertFileLength(long fileLength) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (fileLength <= maxByte) {
            return decimalFormat.format(1.0 * fileLength) + " b";
        } else if (fileLength <= maxKiloByte) {
            return decimalFormat.format(1.0 * fileLength / maxByte) + " kb";
        } else if (fileLength <= maxMegaByte) {
            return decimalFormat.format(1.0 * fileLength / maxKiloByte) + " mb";
        } else {
            return decimalFormat.format(1.0 * fileLength / maxMegaByte) + " gb";
        }
    }
}
