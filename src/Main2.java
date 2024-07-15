
import com.uzabase.processor.BaseProcessor;
import com.uzabase.processor.BaseProcessorImpl;
import com.uzabase.processor.ProcessorFactory;
import com.uzabase.processor.Trim;
import com.uzabase.reader.InputReader;
import com.uzabase.reader.ReaderFactory;
import com.uzabase.writer.OutputWriter;
import com.uzabase.writer.WriterFactory;

import java.util.List;

public class Main2 {

    public static void main(String[] args) throws Exception {

        String input = null;
        String inputSource = null;
        String operation = null;
        String output = null;
        String outputSource = null;
        String replaceFrom = null;
        String replaceTo = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--input=")) {
                input = args[i].substring("--input=".length());
            } else if (args[i].startsWith("--inputSource=")) {
                inputSource = args[i].substring("--inputSource=".length());
            } else if (args[i].startsWith("--operation=")) {
                operation = args[i].substring("--operation=".length());
            } else if (args[i].startsWith("--output=")) {
                output = args[i].substring("--output=".length());
            }else if (args[i].startsWith("--outputSource=")) {
                outputSource = args[i].substring("--outputSource=".length());
            }else if (args[i].startsWith("--replaceFrom=")) {
                replaceFrom = args[i].substring("--replaceFrom=".length());
            }else if (args[i].startsWith("--replaceTo=")) {
                replaceTo = args[i].substring("--replaceTo=".length());
            } else {
                System.out.println("Unknown argument: " + args[i]);
            }
        }
        if(input == null || output == null || operation == null || inputSource == null){
            System.out.println("Required parameters missing. --input, --inputSource, --output and --operation is mandatory");
            return;
        }
        if(output.equals("file") && outputSource == null){
            System.out.println("outputSource is required with the output=file");
            return;
        }
        if(operation.equals("replace") && (replaceTo ==null || replaceFrom == null)){
            System.out.println("replace is used with replaceTo and replaceFrom");
            return;
        }
        InputReader reader = ReaderFactory.createReader(input, inputSource);
        OutputWriter writer = WriterFactory.createWriter(output, outputSource);

        BaseProcessor baseProcessor = new BaseProcessorImpl();
        BaseProcessor processorFactory = ProcessorFactory.createTransformer(operation, baseProcessor, replaceFrom, replaceTo);

        List<String> data = reader.read();
        List<String> formatedData = processorFactory.transform(data, input);
        writer.write(formatedData);

    }

}
