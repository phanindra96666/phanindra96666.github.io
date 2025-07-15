//10 12 10 22 10 18 15 22 10 22 18 18 12 10 22
public class Two{
    public static void main(String [] args){
        int n = 15;
        int [] arr = {10,12,10,22,10,18,15,22,10,22,18,18,12,10,22};
        int [] unique = new int[n];
        int [] freq = new int[n];
        int uniqueCount = 0;

        for(int i=0;i<n;i++){
            int count = 0;
            int alreadyCount = 0;
            for(int j=0;j<uniqueCount;j++){
                if (arr[i]==unique[j]) {
                    alreadyCount++;
                    break;
                }
            }
            
            if(alreadyCount == 0) {
                unique[uniqueCount] = arr[i];
                for(int j=0;j<n;j++){
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }
                freq[uniqueCount] = count;
                uniqueCount++;
            }
        }

        int [] evenEle = new int[uniqueCount];
        int [] evenfreq = new int[uniqueCount];
        int evencount = 0;

        int [] oddEle = new int[uniqueCount];
        int [] oddfreq = new int[uniqueCount];
        int oddcount = 0;

        for(int i=0;i<uniqueCount;i++){
            if (freq[i]%2==0) {
                evenfreq[evencount] = freq[i];
                evenEle[evencount] = unique[i];
                evencount++;
            }
            else{
                oddfreq[oddcount] = freq[i];
                oddEle[oddcount] = unique[i];
                oddcount++;
            }
        }

        for(int i=0;i<oddcount - 1;i++){
            for(int j=0;j<oddcount -i - 1;j++){
                if(oddfreq[j]<oddfreq[j+1]){
                    int fre = oddfreq[j+1];
                    oddfreq[j+1] = oddfreq[j];
                    oddfreq[j] = fre;

                    int temp = oddEle[j+1];
                    oddEle[j+1] = oddEle[j];
                    oddEle[j] = temp;
                }
            }
        }

        for(int i=0;i<evencount - 1;i++){
            for(int j=0;j<evencount -i - 1;j++){
                if(evenfreq[j]>evenfreq[j+1]){
                    int fre = evenfreq[j+1];
                    evenfreq[j+1] = evenfreq[j];
                    evenfreq[j] = fre;

                    int temp = evenEle[j+1];
                    evenEle[j+1] = evenEle[j];
                    evenEle[j] = temp;
                }
            }
        }

        for (int i = 0; i < oddcount; i++) {
            System.out.println(oddEle[i] + " -> " + oddfreq[i]);
        }

        for (int i = 0; i < evencount; i++) {
            System.out.println(evenEle[i] + " -> " + evenfreq[i]);
        }



    }
}