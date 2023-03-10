using Know_Your_Learning.ViewModels;
using Microsoft.UI.Xaml;
using Microsoft.UI.Xaml.Controls;

namespace Know_Your_Learning.Views.Pages;

public sealed partial class MainPage : Page
{
    public MainPage()
    {
        ViewModel = App.GetService<MainViewModel>();
        InitializeComponent();
    }

    public MainViewModel ViewModel
    {
        get;
    }

    private void Nav_Import(object sender, RoutedEventArgs e) => Frame.Navigate(typeof(ImportPage), "ImportPage");
}