public class MergeSortTest
{
double[] arr;
int nElem;

public MergeSortTest(int n)
{
arr=new double[n];
nElem=0;
}


public void insert(int num)
{
arr[nElem]=num;
//System.out.println(arr[nElem]+" Inserted");
nElem++;

}

public void display()
{
for(int outer=0;outer<arr.length;outer++)
System.out.println(arr[outer]);
}

public void mergeSort()
{
double[] workspace=new double[nElem];
recMergeSort(workspace,0,nElem-1); 
}

public void recMergeSort(double[] workspace,int lowerBound,int upperBound)
{
if(lowerBound==upperBound)
return;
else
{
int mid=(lowerBound+upperBound)/2;
recMergeSort(workspace,lowerBound,mid);
recMergeSort(workspace,mid+1,upperBound);
merge(workspace,lowerBound,mid+1,upperBound);
}
}

public void merge(double[] workspace,int lowPtr,int highPtr,int upperBound)
{
int j=0;
int lowerBound=lowPtr;
int mid=highPtr-1;
int n=upperBound-lowerBound+1;

while(lowPtr<=mid && highPtr<=upperBound)
{
if(arr[lowPtr]<=arr[highPtr])
{
workspace[j++]=arr[lowPtr++];
}
else
{
workspace[j++]=arr[highPtr++];
}
}

while(lowPtr<=mid)
{
workspace[j++]=arr[lowPtr++];
}
while(highPtr<=upperBound)
{
workspace[j++]=arr[highPtr++];
}

for(j=0;j<n;j++)
{
arr[lowerBound+j]=workspace[j];
}
}

public static void main(String[] args)
{

MergeSortTest is=new MergeSortTest(7);
is.insert(22);
is.insert(2);
is.insert(32);
is.insert(552);
is.insert(26);
is.insert(1);
is.insert(44);
is.mergeSort();
is.display();

}
}