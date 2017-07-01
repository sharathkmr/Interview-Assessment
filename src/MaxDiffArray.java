
public class MaxDiffArray {

	public static void main(String[] args) {
		// int a[] = {};
		// maxDifference(a);
	}
	
	public static int maxDifference(int[] a) {
        int min = a[0];
        int diff = a[1]-a[0];
        
        for(int i=0;i<a.length;i++) {
            if(a[i]-min > diff) {
                diff = a[i]-min;
            
            }
            if(a[i]< min) {
                min=a[i];
            }
        }
        if(diff==0) {
            return -1;
        }
        return diff;
    }

}
