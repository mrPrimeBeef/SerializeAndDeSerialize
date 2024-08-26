public class Main {

    public static void main(String[] args) {
        String m = "Hej";

        byte[] byteArray = convertStringToByteArray(m);
        String bitString = convertStringToBitString(byteArray);
        byte[] newByteArray = convertBitStringToByeArray(bitString);
        String deSerializedString = convertByteArrayToString(newByteArray);

        System.out.println(deSerializedString);
    }

    private static String convertByteArrayToString(byte[] byteArray) {
        return new String(byteArray);
    }

    private static byte[] convertBitStringToByeArray(String bitString) {
        int numberOfBytes = bitString.length() / 8;

        byte[] byteArray = new byte[numberOfBytes];

        for (int i = 0; i < numberOfBytes; i++) {
            int index = i * 8;
            String byteBits = bitString.substring(index, index + 8);
            byteArray[i] = (byte) Integer.parseInt(byteBits, 2);
        }
        return byteArray;
    }

    private static String convertStringToBitString(byte[] byteArray) {
        StringBuilder binaryString = new StringBuilder();

        for (byte b : byteArray) {
            String binaryRepresentation = "";
            int value = b;
            // convert byte to String
            for (int i = 0; i < 8; i++){
                binaryRepresentation = (value % 2) + binaryRepresentation;
                value /= 2;
            }
            binaryString.append(binaryRepresentation);
        }
        return binaryString.toString();
    }

    public static byte[] convertStringToByteArray(String m){
        if (!m.isEmpty())
            return m.getBytes();

        return new byte[0];

        }
    }
